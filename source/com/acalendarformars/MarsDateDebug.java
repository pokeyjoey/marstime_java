/**
* This program calculates the current data on Mars according to a 
* calendar invented by Dr. Robert Zubrin.
*
* @author Jeff Roche
* @version 1.0
* @since 2018-02-04
*/
package com.acalendarformars;

import java.util.Collection;
import java.util.TreeMap;
import java.util.Map;
import java.util.Calendar;

public class MarsDateDebug {
    
    public static final int SOLS_IN_YEAR = 669;
    public static final TreeMap<Integer, String> MONTHS_OF_MARS = new TreeMap<Integer, String>();
	private Calendar today = Calendar.getInstance();

	/**
	 * MONTHS_OF_MARS TreeMap has a key value of the day of the
	 * martian year that corresponds to the last day of the month
	 * of its corresponding Martian month.
	 */
	static {
        MONTHS_OF_MARS.put(61, "Gemini");
        MONTHS_OF_MARS.put(126, "Cancer");
        MONTHS_OF_MARS.put(192, "Leo");
        MONTHS_OF_MARS.put(257, "Virgo");
        MONTHS_OF_MARS.put(317, "Libra");
        MONTHS_OF_MARS.put(317, "Libra");
        MONTHS_OF_MARS.put(371, "Scorpius");
        MONTHS_OF_MARS.put(421, "Sagittarius");
        MONTHS_OF_MARS.put(468, "Capricorn");
        MONTHS_OF_MARS.put(514, "Aquarius");
        MONTHS_OF_MARS.put(562, "Pisces");
        MONTHS_OF_MARS.put(613, "Aries");
        MONTHS_OF_MARS.put(669, "Taurus");
	}

    public MarsDateDebug() {
        System.out.println("Get your Ass to Mars !!");
		System.out.println("Todays Mars Date: " + today());
    }

	/**
	 * Return todays Martian Calendar date provided with an equivalent
	 * Earth date represented by a datetime.date object.
	 */
	public String today() {
		String todaysMartianDate = getMarsDate(today);

		return todaysMartianDate;
	}

	/**
     * Return martian date for the Zubrin Calendar when
	 * provided with a Calendar object for its corresponding Earth Date.
     * - returns date of the form: year-month- day of month
     *    (Roman Numberal) example - 29 Pisces XLIX
	 * @param earthDate Earth Date equivalent of requesteed Martian Date
     */ 
	private String getMarsDate(Calendar earthCalendar) {
		// Get the month, day, year, and day of year
		int month = earthCalendar.get(Calendar.MONTH) + 1;
		int day = earthCalendar.get(Calendar.DAY_OF_MONTH);
		int year = earthCalendar.get(Calendar.YEAR);
		int dayOfYear = earthCalendar.get(Calendar.DAY_OF_YEAR);
		double daysInEarthYear = (double) earthCalendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println("month: " + month);
		System.out.println("day: " + day);
		System.out.println("year: " + year);
		System.out.println("dayOfYear: " + dayOfYear);
		System.out.println("daysInEarthYear: " + daysInEarthYear);
		System.out.println();

		// calculate contants for Martian Date Calculation
		double earthYearComplete = (dayOfYear/daysInEarthYear);
		double earthDate = year + earthYearComplete;
		double marsDate = ((8.0/15.0) * (earthDate - 1961.0)) + 1.0;
		double marsYear = Math.floor(marsDate);
		double marsDateComplete = marsDate - marsYear;
		int dayOfYearMars = (int) Math.round(SOLS_IN_YEAR * marsDateComplete);
		System.out.println("earthYearComplete: " + earthYearComplete);
		System.out.println("earthDate: " + earthDate);
		System.out.println("marsDate: " + marsDate);
		System.out.println("marsYear: " + marsYear);
		System.out.println("marsDateComplete: " + marsDateComplete);
		System.out.println("dayOfYearMars: " + dayOfYearMars);
		System.out.println();

		// Calculate the Martian month and day of month
		String monthMars = getMonthOfMars(dayOfYearMars);
		String dayMars = getMonthMarsDayOfMonth(dayOfYearMars);
		String romanMarsYear = RomanNumber.toRoman((int) marsYear);
		String formatedDateMars = String.format("%s %s %s", dayMars, monthMars, romanMarsYear);
		System.out.println("monthMars: " + monthMars);
		System.out.println("dayMars: " + dayMars);
		System.out.println("romanMarsYear: " + romanMarsYear);
		System.out.println("formatedDateMars: " + formatedDateMars);

		return formatedDateMars;
	}

	/**
     * Return the string for the martian month for the supplied day of the year.
	 *
	 * @param dayOfYear Day of the Martian Year.
     */ 
	private String getMonthOfMars(long dayOfYearMars) {

		String monthOfMars = "Set me";

		// Iterate through MONTHS_OF_MARS until 
	    // the dayOfYear is less than the lastDayOfMonth.
		// - matching Month contains that dayOfYearMars
		for (Map.Entry<Integer,String> entry : MONTHS_OF_MARS.entrySet()) {
			Integer lastDayOfMonthMars = entry.getKey();
			String marsMonthName = entry.getValue();
			if (dayOfYearMars <= lastDayOfMonthMars) {
				monthOfMars = marsMonthName;
				break;
			}
		}

		return monthOfMars;
	}

	/**
     * Return the string for the date of the martian month for the supplied day of the year.
	 *
	 * @param dayOfYear Day of the Martian Year.
     */ 

	private String getMonthMarsDayOfMonth(int dayOfYearMars) {

        // initialize to Gemini the first month of the Martian year
        int lastDayOfPreviousMonth = 61;
        int dayOfMonth = 0;

        // if we are in the first month Gemini,
		//  dayOfMonth equals the dayOfYearMars.
        if (dayOfYearMars <= 61) {
            dayOfMonth = dayOfYearMars;
            return Integer.toString(dayOfMonth);
		};

        // determine which month we are in so we 
		// can calculate the day of the month.
   		for (Map.Entry<Integer,String> entry : MONTHS_OF_MARS.entrySet()) {
			Integer lastDayOfMonthMars = entry.getKey();
			String marsMonthName = entry.getValue();
            if (dayOfYearMars <= lastDayOfMonthMars) {
                dayOfMonth = (dayOfYearMars - (lastDayOfPreviousMonth + 1)) + 1;
                break;
			};

            lastDayOfPreviousMonth = lastDayOfMonthMars;
		}

        return Integer.toString(dayOfMonth);
	}
}
