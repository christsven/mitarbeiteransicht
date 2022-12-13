package com.itf201.mitarbeiteransicht.command.commands;

public class UndoCommand extends Command {
    Command command;

    public UndoCommand(Command command) {
        this.command = command;
    }

    @Override
    void execute() {
        command.execute();
    }

    @Override
    void undo() {
        command.undo();
    }
}
