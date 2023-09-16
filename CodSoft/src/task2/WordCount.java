package task2;

import java.util.Scanner;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class WordCount {
        public static void main(String[] args) {
            // Prompt the user to enter a text or provide a file
            System.out.println("Choose an option:");
            System.out.println("1. Enter text");
            System.out.println("2. Provide a file path");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            String input = "";
            if (choice == 1) {
                // Read input from the user
                System.out.println("Enter text:");
                scanner.nextLine(); // Consume the newline
                input = scanner.nextLine();
            } else if (choice == 2) {
                // Read input from a file
                System.out.println("Enter file path:");
                scanner.nextLine(); // Consume the newline
                String filePath = scanner.nextLine();
                input = readFile(filePath);
                if (input == null) {
                    System.err.println("Error: Unable to read the file. Please check the file path.");
                    System.exit(1); // Exit the program with an error code
                }
            } else {
                System.err.println("Error: Invalid choice. Please select 1 or 2.");
                System.exit(1); // Exit the program with an error code
            }

            // Split the input into an array of words
            String[] words = input.split("\\s+|\\p{Punct}");

            // Initialize a counter for total words and a map to store word frequencies
            int totalWords = 0;
            Map<String, Integer> wordFrequency = new HashMap<>();

            // Iterate through the words
            for (String word : words) {
                if (!word.isEmpty()) { // Skip empty words
                    totalWords++;
                    wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
                }
            }

            // Display the total word count
            System.out.println("Total word count: " + totalWords);

            // Display word frequency statistics
            System.out.println("Word frequency statistics:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            scanner.close();
        }

        private static String readFile(String filePath) {
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                return content.toString();
            } catch (IOException e) {
                // Handle the exception and return null if there's an error reading the file
                e.printStackTrace();
                return null;
            }
        }
    }






