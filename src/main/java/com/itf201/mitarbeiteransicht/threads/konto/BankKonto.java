package com.itf201.mitarbeiteransicht.threads.konto;

public class BankKonto {

    private int amount;

    public BankKonto(int amount) {
        this.amount = amount;
    }

    public void deposit(int putAmount) {
        System.out.println("Deposit " + putAmount + "€ to deposit of " + amount + "€.");
        amount = amount + putAmount;
        soutAmount();
    }

    public void withdraw(int getAmount) {
        System.out.println("Try to withdraw " + getAmount + "€ from deposit of " + amount + "€.");
        amount = getAmount > amount ? 0 : amount - getAmount;
        soutAmount();
    }

    private void soutAmount() {
        System.out.println("Current amount is " + amount + "€.");
    }

}
