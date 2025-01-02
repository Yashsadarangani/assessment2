package com.example.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmstrongNumberTest {

    @Test
    public void testIsArmstrong() {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();

        // Test cases for Armstrong numbers
        assertTrue(armstrongNumber.isArmstrong(153), "153 should be an Armstrong number");
        assertTrue(armstrongNumber.isArmstrong(9474), "9474 should be an Armstrong number");
        assertTrue(armstrongNumber.isArmstrong(9474), "9474 should be an Armstrong number");

        // Test cases for non-Armstrong numbers
        assertFalse(armstrongNumber.isArmstrong(123), "123 should not be an Armstrong number");
        assertFalse(armstrongNumber.isArmstrong(100), "100 should not be an Armstrong number");
    }

    @Test
    public void testSingleDigitNumbers() {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();

        // Single-digit numbers are Armstrong by default
        for (int i = 0; i <= 9; i++) {
            assertTrue(armstrongNumber.isArmstrong(i), i + " should be an Armstrong number");
        }
    }
}
