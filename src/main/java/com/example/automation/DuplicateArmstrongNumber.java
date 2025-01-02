package com.example.automation;

public class DuplicateArmstrongNumber {

    // Method to check if a number is an Armstrong number
    public boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();

        while (number != 0) {
            int remainder = number % 10;
            sum += Math.pow(remainder, digits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    // Duplicate method 1 (slight change in variable names)
    public boolean checkArmstrong(int num) {
        int origNum = num;
        int total = 0;
        int digitCount = String.valueOf(num).length();

        while (num != 0) {
            int rem = num % 10;
            total += Math.pow(rem, digitCount);
            num /= 10;
        }

        return total == origNum;
    }

    // Duplicate method 2 (directly checks another hardcoded number)
    public boolean isHardcodedArmstrong() {
        int hardcodedNumber = 9474;
        int originalNumber = hardcodedNumber;
        int sum = 0;
        int digits = String.valueOf(hardcodedNumber).length();

        while (hardcodedNumber != 0) {
            int remainder = hardcodedNumber % 10;
            sum += Math.pow(remainder, digits);
            hardcodedNumber /= 10;
        }

        return sum == originalNumber;
    }

    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();

        int testNumber1 = 153;
        int testNumber2 = 9474;

        // Using the original method
        if (armstrongNumber.isArmstrong(testNumber1)) {
            System.out.println(testNumber1 + " is an Armstrong number.");
        } else {
            System.out.println(testNumber1 + " is not an Armstrong number.");
        }

        // Using the duplicate method 1
        if (armstrongNumber.checkArmstrong(testNumber2)) {
            System.out.println(testNumber2 + " is an Armstrong number.");
        } else {
            System.out.println(testNumber2 + " is not an Armstrong number.");
        }

        // Using the duplicate method 2
        if (armstrongNumber.isHardcodedArmstrong()) {
            System.out.println("9474 is an Armstrong number.");
        } else {
            System.out.println("9474 is not an Armstrong number.");
        }
    }
}
