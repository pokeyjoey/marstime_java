package com.acalendarformars;

import java.util.TreeMap;

public class MarsDateTest {

    public static void main(String[] args) {
        MarsDate marsDate = new MarsDate();

        // Get the Months of Mars
        TreeMap<Integer, String> monthsOfMars = marsDate.getMonthsOfMars();
        System.out.println(monthsOfMars); 
    }
}
