package com.example.automation;

public class DuplicateArmstrongNumber {

    // Original method
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

    // Duplicate method 1
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

    // Duplicate method 2
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

    // Duplicate method 3
    public boolean verifyArmstrong(int inputNumber) {
        int tempNumber = inputNumber;
        int resultSum = 0;
        int digitLength = String.valueOf(inputNumber).length();

        while (tempNumber != 0) {
            int digit = tempNumber % 10;
            resultSum += Math.pow(digit, digitLength);
            tempNumber /= 10;
        }

        return resultSum == inputNumber;
    }

    // Duplicate method 4
    public boolean validateArmstrongNumber(int givenNumber) {
        int backupNumber = givenNumber;
        int computedSum = 0;
        int numberOfDigits = String.valueOf(givenNumber).length();

        while (givenNumber != 0) {
            int currentDigit = givenNumber % 10;
            computedSum += Math.pow(currentDigit, numberOfDigits);
            givenNumber /= 10;
        }

        return computedSum == backupNumber;
    }

    public static void main(String[] args) {
        DuplicateArmstrongNumber armstrongNumber = new DuplicateArmstrongNumber();

        int testNumber1 = 153;
        int testNumber2 = 9474;

        // Using the original method
        System.out.println(testNumber1 + " is an Armstrong number: " + armstrongNumber.isArmstrong(testNumber1));

        // Using duplicate methods
        System.out.println(testNumber2 + " is an Armstrong number (checkArmstrong): " + armstrongNumber.checkArmstrong(testNumber2));
        System.out.println(testNumber2 + " is an Armstrong number (isHardcodedArmstrong): " + armstrongNumber.isHardcodedArmstrong());
        System.out.println(testNumber2 + " is an Armstrong number (verifyArmstrong): " + armstrongNumber.verifyArmstrong(testNumber2));
        System.out.println(testNumber2 + " is an Armstrong number (validateArmstrongNumber): " + armstrongNumber.validateArmstrongNumber(testNumber2));
    }
}
