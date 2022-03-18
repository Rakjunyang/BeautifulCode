import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        // TODO: args[0], args[1]로 받을 것인가요?
        String inputFileName = "input_20_20.txt";
        String outputFileName = "output_20_20.txt";

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
