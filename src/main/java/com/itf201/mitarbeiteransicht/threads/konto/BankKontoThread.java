package com.itf201.mitarbeiteransicht.threads.konto;

public class BankKontoThread extends Thread {

    private final BankKonto konto;

    public BankKontoThread(BankKonto konto) {
        this.konto = konto;
    }


}
