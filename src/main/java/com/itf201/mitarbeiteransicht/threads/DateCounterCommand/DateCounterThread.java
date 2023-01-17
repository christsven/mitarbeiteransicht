package com.itf201.mitarbeiteransicht.threads.DateCounterCommand;

public class DateCounterThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            new CounterCommand(i).execute();
            new DateCommand().execute();
        }
    }
}
