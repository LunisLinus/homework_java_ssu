package org.labs.Tasks2.Task13;

public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("гостиной");
        TV livingRoomTV = new TV("гостиной");
        AirConditioner livingRoomAC = new AirConditioner("гостиной");

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command tvOn = new TVOnCommand(livingRoomTV);
        Command tvOff = new TVOffCommand(livingRoomTV);
        Command acOn = new AirConditionerOnCommand(livingRoomAC);
        Command acOff = new AirConditionerOffCommand(livingRoomAC);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(tvOff);
        remote.pressButton();

        System.out.println("Отмена последней команды:");
        remote.pressUndo();

        Command[] goodNightCommands = { lightOff, tvOff, acOff };
        Command goodNightMacro = new MacroCommand(goodNightCommands);
        remote.setCommand(goodNightMacro);
        System.out.println("Выполнение макрокоманды 'Спокойной ночи':");
        remote.pressButton();

        System.out.println("Отмена макрокоманды 'Спокойной ночи':");
        remote.pressUndo();
    }
}
