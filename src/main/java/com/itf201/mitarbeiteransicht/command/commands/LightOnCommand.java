package com.itf201.mitarbeiteransicht.command.commands;

import com.itf201.mitarbeiteransicht.command.receiver.Light;

public class LightOnCommand extends Command {

    Light receiver;

    public LightOnCommand(Light receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.startLight();
    }

    @Override
    public void undo() {
        receiver.stopLight();
    }
}
