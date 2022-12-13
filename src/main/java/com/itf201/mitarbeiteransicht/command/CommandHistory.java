package com.itf201.mitarbeiteransicht.command;

import com.itf201.mitarbeiteransicht.command.commands.Command;

import java.util.Stack;

public class CommandHistory {

    private Stack<Command> history;

    /**
     * Puts command on stack
     */
    public void push(Command command) {
        history.push(command);
    }

    /**
     * Executes and deletes first command
     */
    public void pop() {
        Command command = history.pop();
        command.execute();
    }

}
