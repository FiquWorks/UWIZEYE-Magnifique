import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import lemigohotel.HotelMain;
import realconstructor.ConstructorMain;
import trafficfinesystem.TrafficMain;

public class MainLauncher {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("=== Multi-Project Launcher ===");
            System.out.println("1. Lemigo Hotel Management System");
            System.out.println("2. Real Constructor Material Management");
            System.out.println("3. Traffic Fine System");
            System.out.println("0. Exit");

            System.out.print("Select a project to run: ");
            String input = null;

            try {
                // Read input from the user
                input = reader.readLine().trim();
            } catch (IOException e) {
                System.out.println("[Error] Error reading input.");
                break;  // Exit loop on error
            }

            // Handle empty input
            if (input.isEmpty()) {
                System.out.println("\n[Error] No input received. Exiting launcher.");
                break;  // Exit loop on empty input
            }

            // Try parsing the input to an integer
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[Error] Please enter a valid number.");
                continue;  // Prompt again if invalid input
            }

            // Switch based on the user's choice
            switch (choice) {
                case 1:
                    HotelMain.main(null);  // Run Lemigo Hotel System
                    break;
                case 2:
                    ConstructorMain.main(null);  // Run Real Constructor System
                    break;
                case 3:
                    TrafficMain.main(null);  // Run Traffic Fine System
                    break;
                case 0:
                    System.out.println("Exiting launcher. Goodbye!");
                    try {
                        reader.close();  // Close the reader to release resources
                    } catch (IOException e) {
                        System.out.println("[Error] Error closing reader.");
                    }
                    return;  // Exit the program
                default:
                    System.out.println("[Error] Invalid option. Please select 0–3.");
            }

            System.out.println();  // Add spacing after each run
        }
    }
}
