package org.labs.Tasks2.Task13;

class LightOffCommand implements Command {
    private final Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.off();
    }
    @Override
    public void undo() {
        light.on();
    }
}
