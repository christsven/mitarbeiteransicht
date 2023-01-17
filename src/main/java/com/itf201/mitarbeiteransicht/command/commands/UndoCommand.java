package com.itf201.mitarbeiteransicht.command.commands;

public class UndoCommand extends Command {
    Command command;

    public UndoCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.execute();
    }

    @Override
    public void undo() {
        command.undo();
    }
}
