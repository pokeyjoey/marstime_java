/**
* This program calculates the current data on Mars according to a 
* calendar invented by Dr. Robert Zubrin.
*
* @author Jeff Roche
* @version 1.0
* @since 2018-02-04
*/
package com.acalendarformars;

import java.util.TreeMap;

public class MarsDate {
    
    private int SOLS_IN_YEAR = 669;
    private TreeMap<Integer, String> monthsOfMars = new TreeMap<Integer, String>();

    public MarsDate () {
        System.out.println("Get your Ass to Mars !!");
        initializeMonthsOfMars();
    }

    private void initializeMonthsOfMars() {
        monthsOfMars.put(61, "Gemini");
        monthsOfMars.put(126, "Cancer");
        monthsOfMars.put(192, "Leo");
        monthsOfMars.put(257, "Virgo");
        monthsOfMars.put(317, "Libra");
        monthsOfMars.put(317, "Libra");
        monthsOfMars.put(371, "Scorpius");
        monthsOfMars.put(421, "Sagittarius");
        monthsOfMars.put(468, "Capricorn");
        monthsOfMars.put(514, "Aquarius");
        monthsOfMars.put(562, "Pisces");
        monthsOfMars.put(613, "Aries");
        monthsOfMars.put(669, "Taurus");
    }

    public TreeMap<Integer, String> getMonthsOfMars() {
        return monthsOfMars;
    }


}
