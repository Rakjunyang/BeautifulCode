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
            System.out.println("Input 파일이 존재하지 않거나, Output 파일이 이미 존재합니다.");
            return;
        }

        EmployeeManager employeeManager = new EmployeeManager();

        while(true){
            String cmd = fileManager.inputBuffer.readLine();
            if (cmd == null) break;

            try {
                ArrayList<String> data = Parser.parse(cmd);
                InputManager inputManager = new InputManager(data);
                ArrayList<String> result = inputManager.getOperator().executeOperator(employeeManager,
                    inputManager.getOptionSelector());
                /*
                ResultWriter resultWriter = new ResultMakerFactory.getResultWriter(fileManager, inputManager.getPOption());
                resultWriter.write
                */

            }
            catch (Exception e){
                continue;
            }


        }
        fileManager.closeFile();
    }
}
