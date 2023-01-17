package com.itf201.mitarbeiteransicht.threads.DateCounterCommand;

import com.itf201.mitarbeiteransicht.command.commands.Command;

public class CounterCommand extends Command {

    private int value;

    public CounterCommand(int value) {
        this.value = value;
    }

    @Override
    public void execute() {
        System.out.println(value);
    }

    @Override
    public void undo() {
        System.out.println(value);
    }
}
