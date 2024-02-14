
//Write a Java Program to demonstrate the implementation of reading and writing binary data in Java.

//The third term work focuses on reading and writing binary data in Java, a fundamental aspect
//of low-level data manipulation.

// Implementation using ByteStream Class :
// Implementation of InputStreamReader, FileInputStream and FileOutputStream Class

import java.io.*;
public class TW3{
    public static void main(String[] args) {
        try{
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the source file name: ");
            String sourceFileName=reader.readLine();
            System.out.print("Enter the destination file name: ");
            String destinationFileName=reader.readLine();
            System.out.println("Enter text to be written to the source file: ");
            String text=reader.readLine();
            writeTextToFile(sourceFileName,text);
            copyAlternateBytes(sourceFileName,destinationFileName);
            compareFileProperties(sourceFileName, destinationFileName);
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private static void writeTextToFile(String fileName, String text) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(text.getBytes());
        }
    }

   
    private static void copyAlternateBytes(String sourceFile, String destFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            int data;
            int count = 0;
            while ((data = fis.read()) != -1) {
                if (count % 2 == 0) {
                    fos.write(data);
                }
                count++;
            }
        }
    }

    private static void compareFileProperties(String file1, String file2) {
        File sourceFile = new File(file1);
        File destFile = new File(file2);
        if (sourceFile.exists() && destFile.exists()) {
            System.out.println("File Properties Comparison:");
            System.out.println("Source File Name: " + sourceFile.getName());
            System.out.println("Destination File Name: " + destFile.getName());
            System.out.println("Source File Length: " + sourceFile.length() + " bytes");
            System.out.println("Destination File Length: " + destFile.length() + " bytes");
            System.out.println("Source File Readable: " + sourceFile.canRead());
            System.out.println("Destination File Writable: " + destFile.canWrite());
        } else {
            System.out.println("One or both files do not exist.");
        }
    }
}
