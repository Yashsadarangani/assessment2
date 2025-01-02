package com.example.automation;

public class ArmstrongNumber {

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

    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();

        int testNumber = 153;
        if (armstrongNumber.isArmstrong(testNumber)) {
            System.out.println(testNumber + " is an Armstrong number.");
        } else {
            System.out.println(testNumber + " is not an Armstrong number.");
        }
    }
}
