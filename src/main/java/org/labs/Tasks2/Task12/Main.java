package org.labs.Tasks2.Task12;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.setText("Hello, world!");
        System.out.println("Начальный текст: " + editor.getText());
        caretaker.saveState(editor);

        editor.appendText(" How are you?");
        System.out.println("После добавления: " + editor.getText());
        caretaker.saveState(editor);

        editor.appendText(" I hope you are doing well.");
        System.out.println("После второго добавления: " + editor.getText());
        caretaker.saveState(editor);

        caretaker.undo(editor);
        System.out.println("После первого отката: " + editor.getText());

        caretaker.undo(editor);
        System.out.println("После второго отката: " + editor.getText());

        caretaker.undo(editor);
        System.out.println("После третьего отката: " + editor.getText());
    }
}
