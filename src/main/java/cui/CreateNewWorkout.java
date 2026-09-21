package cui;

import domain.DomainController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateNewWorkout extends BaseApplication {
    public CreateNewWorkout(DomainController dc, Scanner scanner) {
        super(dc, scanner);
    }

    public void start() {
        createWorkout();
        addExercisesToWorkout();
    }

    private void createWorkout() {
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Workout name: ");
                String name = scanner.nextLine();
                dc.createWorkout(name);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void addExercisesToWorkout() {
        boolean stop = false;
        while (!stop) {
            try {
                System.out.print("Exercise name: ");
                String name = scanner.nextLine();
                System.out.print("Number of sets: ");
                int numberOfSets = Integer.parseInt(scanner.nextLine());
                System.out.print("Additional notes (leave empty to skip): ");
                String notes = scanner.nextLine();
                dc.addExerciseToWorkout(name, numberOfSets, notes);
                boolean validAnswer = false;
                while (!validAnswer) {
                    System.out.print("Add another exercise? (y/n): ");
                    String answer = scanner.nextLine();
                    if (answer.equals("y") || answer.equals("n")) {
                        validAnswer = true;
                        stop = answer.equals("n");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.print("You need to enter the correct datatype!");
            }
        }

    }
}
