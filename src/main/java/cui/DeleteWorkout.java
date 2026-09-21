package cui;

import domain.DomainController;
import exceptions.NoElementsFoundInDatabase;

import java.util.List;
import java.util.Scanner;

public class DeleteWorkout extends BaseApplication {
    public DeleteWorkout(DomainController dc, Scanner scanner) {
        super(dc, scanner);
    }

    public void start() {
        deleteWorkout();
    }

    private void deleteWorkout() {
        boolean valid = false;
        while (!valid) {
            try {
                String workouts = giveWorkouts();
                if (workouts.isEmpty()) {
                    throw new NoElementsFoundInDatabase("No workouts where found inside the database!");
                }
                System.out.print("Pick workout to delete: ");
                String chosenWorkout = scanner.nextLine();
                dc.deleteWorkout(chosenWorkout);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }
}
