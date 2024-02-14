/*
Write a Java Program to demonstrate the implementation of stream classes in Java. Assume
that an input file named "input.txt" already exists with few lines of random text. Accept
a filename from the user, this will be the destination file.

Write a menu-driven program to do the following:
1) Transfer the contents of the input file to the destination file using the ByteArrayInputStream class
2) Display the contents of the destination file.
*/

// Implementation using ByteStream Class :
// Implementation of InputStreamReader, FileInputStream and FileOutputStream Class

import java.io.*;

public class TW2 {
    public static void main(String[] args) {
        try {
            InputStreamReader i= new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(i);
            String inputFileName = "tw2Input.txt"; // Assume the input file is named "input2.txt"
            
            System.out.println("Enter the destination file name: ");
            String outputFileName = br.readLine();
            
            // Menu-driven options
            System.out.println("Choose an operation:");
            System.out.println("1) Transfer the contents of the input file to the destination file");
            System.out.println("2) Display the contents of the destination file");
            int choice = Integer.parseInt(br.readLine()); // for type casting
            
            switch (choice) {
                case 1:
                    transferContents(inputFileName, outputFileName);
                    System.out.println("Contents transferred successfully.");
                    break;
                case 2:
                    displayContents(outputFileName);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void transferContents(String inputFileName, String outputFileName) {
        try(FileInputStream input=new FileInputStream(inputFileName);
            FileOutputStream output=new FileOutputStream(outputFileName)){
            byte[] buffer=new byte[1024];
            int bytesRead;
            while((bytesRead=input.read(buffer))!=-1){
                output.write(buffer,0,bytesRead);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void displayContents(String outputFileName) {
        try(FileInputStream input = new FileInputStream(outputFileName);
            ByteArrayOutputStream output=new ByteArrayOutputStream()){
            byte[] buffer=new byte[1024];
            int bytesRead;
            while((bytesRead=input.read(buffer))!=-1){
                output.write(buffer,0, bytesRead);
            }
            System.out.println("Contents of the destination file");
            System.out.println(output.toString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

