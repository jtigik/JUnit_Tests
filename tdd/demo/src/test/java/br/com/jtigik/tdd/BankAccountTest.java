package br.com.jtigik.tdd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void withdraw_returnsTrue_ifEnoughFunds() {
        BankAccount_II account = new BankAccount_II(500);
        assertTrue(account.withdraw(400));
    }
}
