package fjp_pr12_adi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Example of reading data from one text file
 * and writing the data to another file
 */
public class ReadWriteFile {
    public static void main(String[] args) {

        // Create input and output stream objects
        FileInputStream inStream = null;
        FileOutputStream outStream = null;

        try {
            // File objects (updated file paths)
            File inputFile = new File("input.txt");  // Yours File Path
            File outFile = new File("output.txt");   // Yours File Path

            // Initialize input and output streams
            inStream = new FileInputStream(inputFile);
            outStream = new FileOutputStream(outFile);

            // Buffer for reading data
            byte[] buffer = new byte[1024];
            int length;

            // Copy data to another file
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            // Closing the input/output streams
            inStream.close();
            outStream.close();

            System.out.println("Written content to another file successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
