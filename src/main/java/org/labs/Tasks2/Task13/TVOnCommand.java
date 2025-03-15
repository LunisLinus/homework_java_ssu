package org.labs.Tasks2.Task13;

class TVOnCommand implements Command {
    private final TV tv;
    public TVOnCommand(TV tv) {
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.on();
    }
    @Override
    public void undo() {
        tv.off();
    }
}

