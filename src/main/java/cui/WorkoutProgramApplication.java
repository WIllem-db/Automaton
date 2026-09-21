package cui;

import domain.DomainController;
import exceptions.NoElementsFoundInDatabase;

import java.util.Scanner;

public class WorkoutProgramApplication {
    private final DomainController dc;
    private final Scanner scanner;
    private CreateNewWorkout createNewWorkout;
    private DeleteWorkout deleteWorkout;

    public WorkoutProgramApplication(DomainController dc) {
        this.dc = dc;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice = 0;
        do {
            choice = handleChoice();
            switch (choice) {
                case 1 -> {
                    createNewWorkout = new CreateNewWorkout(dc, scanner);
                    createNewWorkout.start();
                }
                case 2 -> {
                    deleteWorkout = new DeleteWorkout(dc, scanner);
                    try {
                        deleteWorkout.start();
                    } catch (NoElementsFoundInDatabase e) {
                        System.out.print(e.getMessage());
                    }
                }
                case 3 -> System.exit(0);
            }
        } while (choice != 3);
    }

    private int handleChoice() {
        boolean isValid = false;
        int choice = 0;
        while (!isValid) {
            try {
                printMenu();
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 3) {
                    isValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You need to enter a valid number!");
            }
        }
        return choice;
    }

    private void printMenu() {
        String menu = "MENU\n" +
                "1. Create new workout\n" +
                "2. Delete existing workout\n" +
                "3. Exit program\n" +
                "Choose: ";
        System.out.print(menu);
    }
}
