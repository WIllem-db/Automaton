package domain;

public class DomainController {
    private final WorkoutRepository workoutRepository;
    private Workout currentWorkout;

    public DomainController() {
        workoutRepository = new WorkoutRepository();
    }

    public void createWorkout(String name) {
        Workout workout = new Workout(name);
        workoutRepository.addWorkout(workout);
        currentWorkout = workout;
    }

    public void addExerciseToWorkout(String name, int numberOfSets, String notes) {
        currentWorkout.addExercise(name, numberOfSets, notes);
        workoutRepository.addExercisesToWorkout(currentWorkout.getExercises(), currentWorkout);
    }

    public void deleteWorkout(String name) {
        workoutRepository.deleteWorkout(name);
    }

    public String giveAllWorkouts() {
        return workoutRepository.giveAllWorkouts();
    }
}
