package main;

import cui.WorkoutProgramApplication;
import domain.DomainController;

public class StartUp {
    public static void main(String[] args){
        new WorkoutProgramApplication(new DomainController()).start();
    }
}
