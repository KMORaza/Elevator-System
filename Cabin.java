public class Cabin {
    private int currentFloor;
    private boolean emergencyStop;
    private int[] internalRequests;
    public Cabin() {
        this.currentFloor = 0;
        this.emergencyStop = false;
        this.internalRequests = new int[Elevator.TOTAL_FLOORS];
    }
    public void requestFloor(int floor) {
        if (floor >= 0 && floor < Elevator.TOTAL_FLOORS) {
            this.internalRequests[floor]++;
            System.out.println("Internal request for floor " + floor);
        }
    }
    public void emergencyStop() {
        this.emergencyStop = true;
    }
    public void resetEmergencyStop() {
        this.emergencyStop = false;
    }
    public int getCurrentFloor() { return currentFloor; }
    public boolean isEmergencyStop() { return emergencyStop; }
    public int[] getInternalRequests() { return internalRequests; }
}
