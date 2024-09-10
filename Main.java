public class Main {
    public static void main(String[] args) {
        ControlSystem controlSystem = new ControlSystem(3, 10);
        controlSystem.setSchedulingAlgorithm(new PeakTimeSchedulingAlgorithm());
        controlSystem.handleRequest(2, Elevator.Direction.UP);
        controlSystem.handleRequest(5, Elevator.Direction.DOWN);
        controlSystem.dispatchElevator();
    }
}
