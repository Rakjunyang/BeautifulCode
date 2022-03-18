import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private String inputFileName;
    private String outputFileName;

    public FileReader inputFile;
    public BufferedReader inputBuffer;

    FileManager(String inputFileName, String outputFileName){
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public boolean init() throws IOException {
        return loadInputFile() && createOutputFile();
    }

    public boolean loadInputFile() {
        try {
            inputFile = new FileReader(inputFileName);
            inputBuffer = new BufferedReader(inputFile);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean createOutputFile() throws IOException {
        File file = new File(outputFileName);
        return file.createNewFile();
    }

    public void writeOutputFile(String str) throws IOException {
        BufferedWriter outputBufferWriter = new BufferedWriter(new FileWriter(outputFileName, true));
        outputBufferWriter.append(str + "\r\n");
        outputBufferWriter.close();
    }

    public void closeFile() throws IOException {
        if(inputFile != null) inputFile.close();
    }
}
