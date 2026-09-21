package domain;

import java.util.List;

public class Exercise {
    private String name;
    private int numberOfSets;
    private List<Set> sets;
    private String notes;

    public Exercise(String name, int numberOfSets, String notes) {
        setName(name);
        setNumberOfSets(numberOfSets);
        setNotes(notes);
    }

    private void setNumberOfSets(int numberOfSets) {
        if (numberOfSets < 1) {
            throw new IllegalArgumentException("Number of sets must be greater than 0!");
        }
        this.numberOfSets = numberOfSets;
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSets() {
        return numberOfSets;
    }

    public List<Set> getSets() {
        return sets;
    }

    public String getNotes() {
        return notes;
    }

    private void setNotes(String notes) {
        if (notes == null || notes.isBlank()) {
            this.notes = "";
        } else {
            this.notes = notes;
        }
    }
}
