package com.acalendarformars;

public class RomanNumberTest {

	public static void main(String[] args) {

		RomanNumber roman = new RomanNumber();

		// Test a few comman values
		System.out.println("1 in Roman: " + RomanNumber.toRoman(1));
		System.out.println("5 in Roman: " + RomanNumber.toRoman(5));
		System.out.println("10 in Roman: " + RomanNumber.toRoman(10));
		System.out.println("31 in Roman: " + RomanNumber.toRoman(31));
		System.out.println("100 in Roman: " + RomanNumber.toRoman(100));
	}
}
