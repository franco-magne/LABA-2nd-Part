package patterns.mvc.view;

import patterns.mvc.controller.Controller;

import java.util.Scanner;
public class MainMenu {
    private Controller controller;

    public MainMenu(Controller controller){
        this.controller = controller;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== MVC Demo Menu ===");
            System.out.println("1. Show message");
            System.out.println("2. Update message");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Message: " + controller.getSampleMessage());
                    System.out.println("Enter any key to continue...");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Enter new message: ");
                    String newMessage = scanner.nextLine();
                    controller.updateSampleMessage(newMessage);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
        scanner.close();
    }
}
