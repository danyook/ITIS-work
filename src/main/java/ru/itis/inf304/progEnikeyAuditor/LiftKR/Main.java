package ru.itis.inf304.progEnikeyAuditor.LiftKR;

public class Main {
    public static void main(String[] args) throws ElevatorException {


        Elevator[] elevators = new Elevator[7];
        elevators[0] = new EvenElevator();
        elevators[1] = new EvenElevator();
        elevators[2] = new EvenElevator();

        elevators[3] = new OddElevator();
        elevators[4] = new OddElevator();
        elevators[5] = new OddElevator();

        elevators[6] = new EmployeesElevator();

        for (int i = 0; i < 20; i++) {
            System.out.println(elevators[(int)Math.random()*7].callElevator());;

        }

    }
}
