package com.itf201.mitarbeiteransicht.command.commands;

public class RedoCommand extends Command {

    Command command;

    public RedoCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.undo();
    }

    @Override
    public void undo() {
        command.execute();
    }
}
