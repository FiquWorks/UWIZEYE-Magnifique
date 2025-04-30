import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import lemigohotel.HotelMain;
import realconstructor.ConstructorMain;
import trafficfinesystem.TrafficMain;

public class MainLauncher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Multi-Project Launcher ===");
            System.out.println("1. Lemigo Hotel Management System");
            System.out.println("2. Real Constructor Material Management");
            System.out.println("3. Traffic Fine System");
            System.out.println("0. Exit");

            System.out.print("Select a project to run: ");
            int choice;

            try {
                if (!scanner.hasNext()) {
                    // No input (user hit Ctrl+D or closed stream)
                    System.out.println("\n[Error] No input received. Exiting launcher.");
                    break;
                }
                choice = scanner.nextInt();
                scanner.nextLine(); // clear leftover newline
            } catch (InputMismatchException e) {
                System.out.println("[Error] Please enter a valid number.");
                scanner.nextLine(); // clear invalid input
                continue;
            } catch (NoSuchElementException e) {
                System.out.println("[Error] Input stream closed unexpectedly. Exiting launcher.");
                break;
            }

            switch (choice) {
                case 1:
                    HotelMain.main(null);
                    break;
                case 2:
                    ConstructorMain.main(null);
                    break;
                case 3:
                    TrafficMain.main(null);
                    break;
                case 0:
                    System.out.println("Exiting launcher. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("[Error] Invalid option. Please select 0–3.");
            }

            System.out.println(); // spacing after each run
        }

        scanner.close(); // close scanner at the end safely
    }
}
