package org.labs.Tasks2.Task13;

class AirConditionerOffCommand implements Command {
    private final AirConditioner ac;
    public AirConditionerOffCommand(AirConditioner ac) {
        this.ac = ac;
    }
    @Override
    public void execute() {
        ac.off();
    }
    @Override
    public void undo() {
        ac.on();
    }
}
