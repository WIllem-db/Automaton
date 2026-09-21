package domain;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String name;
    private List<Exercise> exercises;

    public Workout(String name) {
        setName(name);
        this.exercises = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Exercise> getExercises() {
        return this.exercises;
    }

    public void addExercise(String name, int numberOfSets, String notes) {
        exercises.add(new Exercise(name, numberOfSets, notes));
    }
}
