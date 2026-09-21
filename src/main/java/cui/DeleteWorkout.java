package cui;

import domain.DomainController;

import java.util.Scanner;

public class DeleteWorkout extends BaseApplication {
    public DeleteWorkout(DomainController dc, Scanner scanner) {
        super(dc, scanner);
    }

    public void start() {
        deleteWorkout();
    }

    private void deleteWorkout() {
        System.out.print(dc.giveAllWorkouts());
        String name = scanner.nextLine();
        dc.deleteWorkout(name);
    }
}
