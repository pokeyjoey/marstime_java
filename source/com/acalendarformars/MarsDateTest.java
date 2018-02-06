package com.acalendarformars;

import java.util.TreeMap;

public class MarsDateTest {

    public static void main(String[] args) {
        MarsDate marsDate = new MarsDate();

		// Call static variables
		System.out.println("SOLS_IN_YEAR:" + MarsDate.SOLS_IN_YEAR);
		System.out.println("MONTHS_OF_MARS:" + MarsDate.MONTHS_OF_MARS);
		System.out.println("Zubrin Calendar Date:" + marsDate.today());
    }
}
