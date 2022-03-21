import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Parser {
    private static boolean isValidPattern(String str){
        String validPattern = "^[a-zA-Z0-9\\s\\,\\-]+$";
        return Pattern.matches(validPattern, str);
    }

    private static boolean isValidOperation(String operation){
        ArrayList<String> supportType = new ArrayList<>(Arrays.asList("ADD", "SCH", "MOD", "DEL"));
        return supportType.contains(operation.toUpperCase());
    }

    private static boolean isValidLength(ArrayList<String> inputList, int optionLength){
        String operation = inputList.get(0).toUpperCase();

        // TODO: 컬럼이 추가되지는 않을까요? parser가 아닌 데이터를 관리하는 쪽으로 이동?
        if (operation.equals("ADD")) return inputList.size() == (1 + optionLength + 6);
        else if (operation.equals("SCH")) return inputList.size() == (1 + optionLength + 2);
        else if (operation.equals("MOD")) return inputList.size() == (1 + optionLength + 4);
        else if (operation.equals("DEL")) return inputList.size() == (1 + optionLength + 2);

        return false;
    }

    private static boolean isValidOption(ArrayList<String> inputList, ArrayList<ArrayList<String>> supportOptions){
        int optionIndex = 1;
        for (ArrayList<String> supportOption: supportOptions){
            if (!supportOption.contains(inputList.get(optionIndex))) return false;
            optionIndex++;
        }
        return true;
    }

    public static ArrayList<String> parse(String str) {
        ArrayList<String> parseResult = new ArrayList<>(Arrays.asList(str.split(",")));

        ArrayList<ArrayList<String>> supportOptions = new ArrayList<>();
        supportOptions.add(new ArrayList<>(Arrays.asList("-p", " ")));
        supportOptions.add(new ArrayList<>(Arrays.asList("-f", "-l", "-m", "-y", "-d", " ")));
        supportOptions.add(new ArrayList<>(Arrays.asList(" ")));

        if (!isValidPattern(str)) return null;
        if (!isValidOperation(parseResult.get(0))) return null;
        if (!isValidLength(parseResult, supportOptions.size())) return null;
        if (!isValidOption(parseResult, supportOptions)) return null;

        return parseResult;
    }
}
