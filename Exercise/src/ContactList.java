import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;
import java.nio.file.Files;
import java.util.*;

/**
 * The purpose of this program is to take the existing file "contacts.txt"
 * and re-format it from "id,first_name,last_name,email" to "last_name,first_name,email".
 * The new re-formatted list should be printed into a new text file created by the program.
 * This new list is named "formatted-contacts.txt".
 */


//Instantiates Class
public class ContactList {
    //Creates private variables
    private String email;
    private String firstName;
    private String lastName;
    private String id;

    public static void main(String[] args){

        System.out.println("\n\tWelcome to my program\n\nPlease enter the path of your file.");
        Scanner in = new Scanner(System.in);
        String filePath = in.next();

        //File Path
        String inputFileName = filePath;
        //String inputFileName = "C:///Users/Cesar Saavedra/Desktop/contacts.txt";
        Path inputFilePath = Paths.get(inputFileName);

        //Try Catch Block for printing what would be on the console directly into a new text file
        try {

            File file = new File("formatted-contacts.txt"); //Creates new output file
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream stream = new PrintStream(fos);
            System.setOut(stream);  //Prints stream to new output file
        } catch (FileNotFoundException e) { //Catches whether file exists
            e.printStackTrace();
        }
        //Try Catch Block for looping reformat
        try {

            //Instantiates Scanner
            Scanner inputFileScanner = new Scanner(inputFilePath);

            //Loops until there are no more lines
            while(inputFileScanner.hasNextLine()) {

                //Sets each line as a String then Splits it into an array list divided by " , "
                String line = inputFileScanner.nextLine();
                List<String> newList = Arrays.asList(line.split(","));

                //Sets variables for the Strings found between the commas
                String firstName = newList.get(1);
                String lastName = newList.get(2);
                String email = newList.get(3);

                //Reformat the line
                System.out.printf("%s,%s,%s\n",lastName,firstName,email);

            }
        }catch(IOException e){  //Catches IO Exception
            e.printStackTrace();
        }

    }
}
