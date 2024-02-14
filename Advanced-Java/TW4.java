//The fourth term work delves into ArrayList operations, showcasing the flexibility of dynamic
//        arrays in Java. The menu-driven Java program allows users to create ArrayLists of integers
//        and floats with user-specified lengths, encapsulating the principles of user-driven dynamic
//        data structures. Overloaded methods are introduced to add and remove elements, providing a
//        clear illustration of the benefits of method overloading.

import java.util.ArrayList;
import java.util.Scanner;

public class TW4{
    private ArrayList<Integer> integerList;
    private ArrayList<Float> floatList;

    //default constructor
    public TW4() {
        integerList = new ArrayList<>();
        //Create an ArrayList object of type float
        floatList=new ArrayList<>();
    }

    // Method to add elements to the integer ArrayList
    public void addElement(int element) {
        integerList.add(element);
    }

    // Method to add elements to the float ArrayList
    public void addElement(float element) {
        floatList.add(element);
    }

    // Method to remove elements from the integer ArrayList
    public void removeElement(int index) {
        if (index >= 0 && index < integerList.size()) {
            integerList.remove(index);
        } else {
            System.out.println("Invalid index for integer ArrayList!");
        }
    }

    // Method to remove elements from the float ArrayList
    public void removeElement(float element) {
        //Remove element
        floatList.remove(element);
    }

    // Method to perform linear search on the integer ArrayList
    public boolean linearSearch(int key) {
        return integerList.contains(key);
    }

    // Method to perform linear search on the float ArrayList
    public boolean linearSearch(float key) {
        //return false;
        return floatList.contains(key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TW4 operations = new TW4();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add an integer element");
            System.out.println("2. Add a float element");
            System.out.println("3. Remove an integer element");
            System.out.println("4. Remove a float element");
            System.out.println("5. Search in integer ArrayList");
            System.out.println("6. Search in float ArrayList");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the integer to add in the list: ");
                    //read an integer  and add element to integer list
                    int value1=scanner.nextInt();
                    operations.addElement(value1);
                    break;
                case 2:
                    System.out.print("Enter the floating value to add in the list: ");
                    //read a float and add element to float list
                    float value2=scanner.nextFloat();
                    operations.addElement(value2);
                    break;
                case 3:
                    System.out.print("Enter the index of integer to remove in the list: ");
                    //read index of element and remove  from integer list
                    int ind=scanner.nextInt();
                    operations.removeElement(ind);
                    break;
                case 4:
                    System.out.print("Enter the floating value to remove in the list: ");
                    //read element and remove  from floatlist
                    float ele=scanner.nextFloat();
                    operations.removeElement(ele);
                    break;
                case 5:
                    System.out.print("Enter the integer to search in the list: ");
                    int intSearchKey = scanner.nextInt();
                    //read int element to be seached and perform a linear Search(return boolean value)
                    boolean intFound=operations.linearSearch(intSearchKey);
                    System.out.println("Integer found: " + intFound);
                    break;
                case 6:
                    System.out.print("Enter the floating value to search in the list: ");
                    float floatSearchKey = scanner.nextFloat();
                    //read float element to be seached and perform a linear Search(return boolean value)
                    boolean floatFound=operations.linearSearch(floatSearchKey);
                    System.out.println("Float found: " + floatFound);
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}