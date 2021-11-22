package com.company;

import com.company.Bank.Bank;
import com.company.Bank.KBBank;
import com.company.Bank.SHBank;


public class Main {
    public static void main(String[] args) {
        Bank bank = new KBBank();
        bank.withDraw(100);
        bank.deposit(100);
        bank.findDormancyAccount("763231");
        Bank.BCAuth("KBBANK");

        System.out.println("\n*****************인스턴스 교체!!******************");

        bank = new SHBank();
        bank.withDraw(100);
        bank.deposit(100);
        bank.findDormancyAccount("763231");
        Bank.BCAuth("KBBANK");
    }
}
