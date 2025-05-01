import java.util.Scanner;

import lemigohotel.HotelMain;
import realconstructor.ConstructorMain;
import trafficfinesystem.TrafficMain;

public class MainLauncher {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("=== Multi-Project Launcher ===");
                System.out.println("1. Lemigo Hotel Management System");
                System.out.println("2. Real Constructor Material Management");
                System.out.println("3. Traffic Fine System");
                System.out.println("0. Exit");
                System.out.print("Select a project to run: ");

                String input;

                try {
                    if (!scanner.hasNextLine()) {
                        System.out.println("\n[Error] No input received. Exiting launcher.");
                        break;
                    }

                    input = scanner.nextLine().trim();

                    if (input.isEmpty()) {
                        System.out.println("[Error] Empty input. Please enter a number between 0–3.");
                        continue;
                    }

                    int choice = Integer.parseInt(input);

                    switch (choice) {
                        case 1:
                            HotelMain.run(scanner);
                            break;
                        case 2:
                            ConstructorMain.run(scanner);
                            break;
                        case 3:
                            TrafficMain.run(scanner);
                            break;
                        case 0:
                            System.out.println("Exiting launcher. Goodbye!");
                            return;
                        default:
                            System.out.println("[Error] Invalid option. Please select 0–3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("[Error] Please enter a valid number.");
                } catch (Exception e) {
                    System.out.println("[Error] An unexpected error occurred: " + e.getMessage());
                }

                System.out.println(); 
            }
        } catch (Exception e) {
            System.out.println("[Error] Critical failure: " + e.getMessage());
        }
    }
}
