import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileManagerTest {

    @Test
    void loadFileTest() throws IOException {
        // Case1: File does not exist
        FileManager fileManager = new FileManager("input_not_exist_case.txt", "dummy.txt");
        assertFalse(fileManager.loadInputFile());

        // Case2: File exist
        File tempFile = new File("input_exist_case.txt");
        tempFile.createNewFile();

        fileManager = new FileManager("input_exist_case.txt", "dummy.txt");
        assertTrue(fileManager.loadInputFile());
        fileManager.closeFile();
        tempFile.delete();
    }

    @Test
    void createOutputFileTest() throws IOException {
        File tempFile = new File("output_create_test.txt");
        tempFile.delete();

        FileManager fileManager = new FileManager("dummy.txt", "output_create_test.txt");
        assertTrue(fileManager.createOutputFile());
        tempFile.delete();
    }

    @Test
    void writeOutputFileTest() throws IOException {
        new File("output_write_test.txt").delete();

        FileManager fileManager = new FileManager("dummy.txt", "output_write_test.txt");
        fileManager.createOutputFile();

        fileManager.writeOutputFile("test_message1");
        fileManager.writeOutputFile("test_message2");

        BufferedReader bufferedReader = new BufferedReader(new FileReader("output_write_test.txt"));
        assertEquals(bufferedReader.readLine(), "test_message1");
        assertEquals(bufferedReader.readLine(), "test_message2");

        bufferedReader.close();
        new File("output_write_test.txt").delete();
    }
}
