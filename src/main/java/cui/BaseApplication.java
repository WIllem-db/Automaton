package cui;

import domain.DomainController;

import java.util.List;
import java.util.Scanner;

public abstract class BaseApplication {
    protected final DomainController dc;
    protected final Scanner scanner;

    public BaseApplication(DomainController dc, Scanner scanner) {
        this.dc = dc;
        this.scanner = scanner;
    }

    public abstract void start();

    // String showcase/return methods (Not for returning individual Strings)

    public String giveWorkouts() {
        List<String> workouts = dc.giveAllWorkouts();
        String workoutsString = "";
        for (int i = 0; i < workouts.size(); i++) {
            workoutsString += String.format("%d. %s", i + 1, workouts.get(i));
        }
        return workoutsString;
    }
}
