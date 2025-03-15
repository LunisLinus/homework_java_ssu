package org.labs.Tasks2.Task13;

class RemoteControl {
    private Command command;
    private Command lastCommand;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        if (command != null) {
            command.execute();
            lastCommand = command;
        }
    }
    public void pressUndo() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}
