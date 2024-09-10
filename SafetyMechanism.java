public class SafetyMechanism {
    private boolean overloadDetected;
    private boolean doorSensorActive;
    public SafetyMechanism() {
        this.overloadDetected = false;
        this.doorSensorActive = true;
    }
    public boolean isOverloadDetected() {
        return overloadDetected;
    }
    public void detectOverload(boolean detected) {
        this.overloadDetected = detected;
        if (detected) {
        }
    }
    public boolean isDoorSensorActive() {
        return doorSensorActive;
    }
    public void setDoorSensorActive(boolean active) {
        this.doorSensorActive = active;
    }
}
