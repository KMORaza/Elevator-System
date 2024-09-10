public class Floor {
    private int floorNumber;
    private boolean upRequest;
    private boolean downRequest;
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.upRequest = false;
        this.downRequest = false;
    }
    public int getFloorNumber() {
        return floorNumber;
    }
    public void requestUp() {
        this.upRequest = true;
        System.out.println("Up request at floor " + floorNumber);
    }
    public void requestDown() {
        this.downRequest = true;
        System.out.println("Down request at floor " + floorNumber);
    }
    public boolean hasUpRequest() {
        return upRequest;
    }
    public boolean hasDownRequest() {
        return downRequest;
    }
    public void clearRequests() {
        this.upRequest = false;
        this.downRequest = false;
    }
}
