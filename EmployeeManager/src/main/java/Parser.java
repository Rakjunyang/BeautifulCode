import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Parser {
    public static ArrayList<String> parse(String str) {
        String validPattern = "^[a-zA-Z0-9\\s\\,\\-]+$";

        if (Pattern.matches(validPattern, str)){
            return new ArrayList<>(Arrays.asList(str.split(",")));
        }
        return null;
    }
}
