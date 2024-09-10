public class Elevator {
    public static final int TOTAL_FLOORS = 10;
    private int currentFloor;
    private boolean doorsOpen;
    private Direction direction;
    private boolean emergencyStop;
    private int[] floorRequests;
    public enum Direction {
        UP, DOWN, NONE
    }
    public Elevator() {
        this.currentFloor = 0;
        this.doorsOpen = false;
        this.direction = Direction.NONE;
        this.emergencyStop = false;
        this.floorRequests = new int[TOTAL_FLOORS];
    }
    public void moveToFloor(int floor) {
        if (floor < 0 || floor >= TOTAL_FLOORS || emergencyStop) {
            System.out.println("Elevator is stopped or invalid floor.");
            return;
        }
        System.out.println("Moving elevator to floor " + floor);
        this.direction = (floor > currentFloor) ? Direction.UP : Direction.DOWN;
        while (currentFloor != floor) {
            currentFloor += (direction == Direction.UP) ? 1 : -1;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Current floor: " + currentFloor);
        }
        this.direction = Direction.NONE;
        openDoors();
    }
    public void openDoors() {
        if (!emergencyStop) {
            this.doorsOpen = true;
            System.out.println("Doors opened at floor " + currentFloor);
        }
    }
    public void closeDoors() {
        this.doorsOpen = false;
        System.out.println("Doors closed at floor " + currentFloor);
    }
    public void addFloorRequest(int floor) {
        if (floor >= 0 && floor < TOTAL_FLOORS) {
            this.floorRequests[floor]++;
        }
    }
    public void handleEmergencyStop() {
        this.emergencyStop = true;
        closeDoors();
        System.out.println("Emergency stop activated!");
    }
    public void resetEmergencyStop() {
        this.emergencyStop = false;
    }
    public int getCurrentFloor() { return currentFloor; }
    public boolean areDoorsOpen() { return doorsOpen; }
    public Direction getDirection() { return direction; }
    public int[] getFloorRequests() { return floorRequests; }
}
