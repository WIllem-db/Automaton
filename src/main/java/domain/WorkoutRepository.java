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

    public void addExercisesToWorkout(List<Exercise> exercises, Workout currentWorkout) {
        workoutMapper.addExercisesToWorkout(exercises, currentWorkout);
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

    // Private helper methods

    private boolean doesWorkoutExist(String name) {
        return workoutMapper.giveWorkout(name) != null;
    }
}
