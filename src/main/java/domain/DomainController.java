package domain;

import java.util.List;

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
        workoutRepository.addExerciseToWorkout(name, numberOfSets, notes, currentWorkout);
    }

    public void addRepTargetsToExercises(List<RepTarget> repTargets) {
        workoutRepository.addRepTargetsToExercises(repTargets, currentWorkout.getExercises());
    }

    public void deleteWorkout(String name) {
        workoutRepository.deleteWorkout(name);
    }

    public List<String> giveAllWorkouts() {
        return workoutRepository.giveAllWorkouts();
    }

    public List<String> giveAllExercisesFromWorkout() {
        return workoutRepository.giveAllExercisesFromWorkout(currentWorkout);
    }
}
