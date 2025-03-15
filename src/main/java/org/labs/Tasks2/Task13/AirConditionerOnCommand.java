package org.labs.Tasks2.Task13;

class AirConditionerOnCommand implements Command {
    private final AirConditioner ac;
    public AirConditionerOnCommand(AirConditioner ac) {
        this.ac = ac;
    }
    @Override
    public void execute() {
        ac.on();
    }
    @Override
    public void undo() {
        ac.off();
    }
}
