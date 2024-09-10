import java.util.ArrayList;
import java.util.List;
public class ControlSystem {
    private List<Elevator> elevators;
    private List<Floor> floors;
    private SchedulingAlgorithm schedulingAlgorithm;
    public ControlSystem(int numElevators, int numFloors) {
        elevators = new ArrayList<>();
        floors = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator());
        }
        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor(i));
        }
    }
    public void setSchedulingAlgorithm(SchedulingAlgorithm algorithm) {
        this.schedulingAlgorithm = algorithm;
    }
    public void handleRequest(int floorNumber, Elevator.Direction direction) {
        if (floorNumber >= 0 && floorNumber < floors.size()) {
            Floor floor = floors.get(floorNumber);
            if (direction == Elevator.Direction.UP) {
                floor.requestUp();
            } else if (direction == Elevator.Direction.DOWN) {
                floor.requestDown();
            }
            if (schedulingAlgorithm != null) {
                schedulingAlgorithm.scheduleElevator(elevators, floors);
            }
        }
    }
    public void dispatchElevator() {
        System.out.println("Dispatching elevator...");
        for (Elevator elevator : elevators) {
            for (Floor floor : floors) {
                if (floor.hasUpRequest() || floor.hasDownRequest()) {
                    elevator.moveToFloor(floor.getFloorNumber());
                    floor.clearRequests();
                    break;
                }
            }
        }
    }
}
