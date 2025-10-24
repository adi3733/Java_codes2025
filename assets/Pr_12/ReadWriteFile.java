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

        // create input and output stream objects
        FileInputStream inStream = null;
        FileOutputStream outStream = null;

        try {
            // Files objects (updated file paths)
            File inputFile = new File("D:\\Collage\\3.TE\\TE SEM 1\\Z.Exp\\Exp.FJP\\FJP_pr12\\input.txt");
            File outFile = new File("D:\\Collage\\3.TE\\TE SEM 1\\Z.Exp\\Exp.FJP\\FJP_pr12\\output.txt");

            // Initialize input and output streams
            inStream = new FileInputStream(inputFile);
            outStream = new FileOutputStream(outFile);

            // The buffer size for reading data
            byte[] buffer = new byte[1024];
            int length;

            // Copy data to another file
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            // Closing the input/output file streams
            inStream.close();
            outStream.close();

            System.out.println("Written Content to another file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

