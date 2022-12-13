package com.itf201.mitarbeiteransicht.command;


import com.itf201.mitarbeiteransicht.command.commands.LightOnCommand;
import com.itf201.mitarbeiteransicht.command.commands.RedoCommand;
import com.itf201.mitarbeiteransicht.command.commands.UndoCommand;
import com.itf201.mitarbeiteransicht.command.receiver.Light;

import javax.swing.*;

public class Application extends JFrame {

    private Light light;

    /*
    Command wird ausgeführt -> UndoHistory den undo() hinzufügen
    Command wird zurückgenommen -> RedoHistory den execute() hinzufügen
    */

    private CommandHistory undoHistory = new CommandHistory();

    private CommandHistory redoHistory = new CommandHistory();

    JButton onButton = new JButton("An");

    JButton offButton = new JButton("Aus");

    JButton redoButton = new JButton("Redo");

    JButton undoButton = new JButton("Undo");

    void createGUI() {

    }

    private void createButtonLogic() {
        onButton.addActionListener(e -> {
            LightOnCommand command = new LightOnCommand(light);
            RedoCommand redo = (RedoCommand) command.backup(false);
            UndoCommand undo = (UndoCommand) command.backup(true);
        });
    }
}

