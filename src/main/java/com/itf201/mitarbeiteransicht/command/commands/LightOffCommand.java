package com.itf201.mitarbeiteransicht.command.commands;

import com.itf201.mitarbeiteransicht.command.receiver.Light;

public class LightOffCommand extends Command {

    Light receiver;

    public LightOffCommand(Light receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.stopLight();
    }

    @Override
    public void undo() {
        receiver.startLight();
    }
}
