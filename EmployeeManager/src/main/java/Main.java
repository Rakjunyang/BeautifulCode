import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        String inputFileName = args[0];
        String outputFileName = args[1];

        FileManager fileManager = new FileManager(inputFileName, outputFileName);
        if (!fileManager.init()){
            System.out.println("Input 파일이 존재하지 않거나, Output 파일이 이미 존재합니다.");
            return;
        }

        while(true){
            String cmd = fileManager.inputBuffer.readLine();
            if (cmd == null) break;
            Parser.parse(cmd);

            // TODO: execute
        }
        fileManager.closeFile();
    }
}
