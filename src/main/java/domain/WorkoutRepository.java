package domain;

import exceptions.WorkoutAlreadyExists;
import persistence.WorkoutMapper;

import java.util.List;


public class WorkoutRepository {
    private final WorkoutMapper workoutMapper;

    public WorkoutRepository() {
        workoutMapper = new WorkoutMapper();
    }

    public void addWorkout(Workout workout) {
        if (doesWorkoutExist(workout.getName())) {
            throw new WorkoutAlreadyExists(
                    String.format("%s already exists!", workout.getName())
            );
        }
        workoutMapper.addWorkout(workout);
    }

    public void addExerciseToWorkout(String name, int numberOfSets, String notes, Workout workout) {
        workoutMapper.addExerciseToWorkout(name, numberOfSets, notes, workout);
    }

    public void deleteWorkout(String name) {
        if (!doesWorkoutExist(name)) {
            throw new IllegalArgumentException(String.format(
                    "%s does not exist!", name
            ));
        }
        workoutMapper.deleteWorkout(name);
    }

    public List<String> giveAllWorkouts() {
         return workoutMapper.giveAllWorkouts();
    }

    public void addRepTargetsToExercises(List<RepTarget> repTargets, List<Exercise> exercises) {
        workoutMapper.addRepTargetsToExercises(repTargets, exercises);
    }

    public List<String> giveAllExercisesFromWorkout(Workout workout) {
        return workoutMapper.giveAllExercisesFromWorkout(workout);
    }

    // Private helper methods

    private boolean doesWorkoutExist(String name) {
        return workoutMapper.giveWorkout(name) != null;
    }
}
