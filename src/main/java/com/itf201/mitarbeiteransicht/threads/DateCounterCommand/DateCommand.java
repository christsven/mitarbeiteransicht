package com.itf201.mitarbeiteransicht.threads.DateCounterCommand;

import com.itf201.mitarbeiteransicht.command.commands.Command;

import java.time.ZonedDateTime;

public class DateCommand extends Command {
    @Override
    public void execute() {
        System.out.println(ZonedDateTime.now());
    }

    @Override
    public void undo() {
        System.out.println("lmao");
    }
}
