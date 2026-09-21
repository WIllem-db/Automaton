package persistence;


import domain.Exercise;
import domain.Workout;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class WorkoutMapper {
    private static final String INSERT_WORKOUT = "INSERT INTO workout(name) VALUES(?)";
    private static final String GIVE_WORKOUT = "SELECT name FROM workout WHERE name = ?";
    private static final String INSERT_EXERCISE = "INSERT INTO exercise(workoutid, name, numberOfSets, notes) " +
            "VALUES((select workoutid from workout where name = ?),?, ?, ?)";
    private static final String DELETE_WORKOUT = "DELETE FROM workout WHERE name = ?";
    private static final String GIVE_ALL_WORKOUTS = "SELECT name FROM workout";

    public void addWorkout(Workout workout) {
        try (Connection connection = DriverManager.getConnection(persistence.Connection.JDBC_URL); PreparedStatement query = connection.prepareStatement(INSERT_WORKOUT)) {
            query.setString(1, workout.getName());
            query.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Workout giveWorkout(String name) {
        try (Connection connection = DriverManager.getConnection(persistence.Connection.JDBC_URL); PreparedStatement query = connection.prepareStatement(GIVE_WORKOUT)) {
            query.setString(1, name);
            try (ResultSet rs = query.executeQuery()) {
                if (rs.next()) {
                    return new Workout(rs.getString("name"));
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addExercisesToWorkout(List<Exercise> exercises, Workout currentWorkout) {
        try (Connection connection = DriverManager.getConnection(persistence.Connection.JDBC_URL); PreparedStatement query = connection.prepareStatement(INSERT_EXERCISE)) {
            for (Exercise exercise : exercises) {
                query.setString(1, currentWorkout.getName());
                query.setString(2, exercise.getName());
                query.setInt(3, exercise.getNumberOfSets());
                query.setString(4, exercise.getNotes());
                query.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteWorkout(String name) {
        try (Connection connection = DriverManager.getConnection(persistence.Connection.JDBC_URL); PreparedStatement query = connection.prepareStatement(DELETE_WORKOUT)) {
            query.setString(1, name);
            query.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> giveAllWorkouts() {
        List<String> workouts = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(persistence.Connection.JDBC_URL); PreparedStatement query = connection.prepareStatement(GIVE_ALL_WORKOUTS)) {
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    workouts.add(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workouts;
    }
}
