import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) throws IOException {
        String inputFileName;
        String outputFileName;

        if (args.length == 2) {
            inputFileName = args[0];
            outputFileName = args[1];
        }
        else{
            System.out.println("[Invalid Argument] EmployeeManager.exe 'inputText.txt' 'outputText.txt'");
            return;
        }

        FileManager fileManager = new FileManager(inputFileName, outputFileName);
        if (!fileManager.init()){
            System.out.println("[File Init Error] Failed to initialize input and output files");
            return;
        }

        EmployeeManager employeeManager = new EmployeeManager();
        ResultMakerFactory resultMakerFactory = new ResultMakerFactory();

        while(true){
            String cmd = fileManager.inputBuffer.readLine();
            if (cmd == null) break;

            try {
                InputManager inputManager = new InputManager(Parser.parse(cmd));

                employeeManager.sort(inputManager.getCommand());

                ArrayList<String> result = inputManager.getOperator().executeOperator(employeeManager,
                    inputManager.getOptionSelector());

                ResultMaker resultMaker = resultMakerFactory.getResultMaker(inputManager.getPOption(), fileManager);
                resultMaker.setResult(result, inputManager.getCommand());
            }
            catch (Exception e){
                continue;
            }
        }
        fileManager.closeFile();
    }
}
