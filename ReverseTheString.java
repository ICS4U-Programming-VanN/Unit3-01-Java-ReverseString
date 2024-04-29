/**
* Reverses Strings from input file
*
* @author  Van Nguyen
* @version 1.0
* @since   2024-04-19
*/

import java.io.*;
import java.util.Scanner;

public class ReverseTheString {
    // Function to reverse a string using recursion
    public static String reverseString(String str) {
        // Base case: if the input string is empty, return it
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        // Try-Catch block for handling exceptions
        try {
            // File paths
            String in = "./input.txt";
            String out = "./output.txt";
            File input = new File(in);
            File output = new File(out);

            // Scanner + Writer
            Scanner scanner = new Scanner(input);
            FileWriter writer = new FileWriter(output);

            // Initialize Variable
            String fileLine;

            // Input from input file
            while (scanner.hasNextLine()) {
                // Read line from input file
                fileLine = scanner.nextLine();
                
                // Skip processing if the line is blank
                if (fileLine.trim().isEmpty()) {
                    continue;
                }

                // Reverse the string
                String reversedString = reverseString(fileLine);

                // Writing the output to output file
                writer.write("Original String: " + fileLine + "\n");
                writer.write("Reversed String: " + reversedString + "\n\n");

                // Prints output to console
                System.out.println("Original String: " + fileLine);
                System.out.println("Reversed String: " + reversedString);
                System.out.println();
            }

            // Closes scanner and writer
            scanner.close();
            writer.close();

        } catch (IOException e) {
            System.out.println("File could not be found. Please fix the file path.");
        }
    }
}
