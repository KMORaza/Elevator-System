import java.util.List;

public class PeakTimeSchedulingAlgorithm implements SchedulingAlgorithm {
    @Override
    public void scheduleElevator(List<Elevator> elevators, List<Floor> floors) {
        Elevator selectedElevator = null;
        int minRequests = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int requests = 0;
            for (int request : elevator.getFloorRequests()) {
                requests += request;
            }
            if (requests < minRequests) {
                minRequests = requests;
                selectedElevator = elevator;
            }
        }
        if (selectedElevator != null) {
            for (Floor floor : floors) {
                if (floor.hasUpRequest() || floor.hasDownRequest()) {
                    selectedElevator.moveToFloor(floor.getFloorNumber());
                    floor.clearRequests();
                    break;
                }
            }
        }
    }
}
