package com.itf201.mitarbeiteransicht.command.commands;

public abstract class Command {

    /**
     * Executes business logic in Receiver class
     */
    public abstract void execute();

    /**
     * Resets command
     */
    public abstract void undo();

    /**
     * Creates Backup command for undo and redo stack
     *
     * @param undo if true undo, else redo command
     */
    public Command backup(boolean undo) {
        return (undo) ? new UndoCommand(this) : new RedoCommand(this);
    }

}
