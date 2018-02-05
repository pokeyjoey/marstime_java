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
import java.util.Calendar;

public class MarsDate {
    
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

    public MarsDate() {
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
	private String getMarsDate(Calendar earthDateCalendar) {
		// Get the month, day, year, and day of year
		int month = Calendar.MONTH;
		int day = Calendar.DAY_OF_MONTH;
		int year = Calendar.YEAR;
		int dayOfYear = Calendar.DAY_OF_YEAR;
		int daysInEarthYear = earthDateCalendar.getActualMaximum(Calendar.DAY_OF_YEAR);

		// calculate contants for Martian Date Calculation
		double earthYearComplete = (dayOfYear/daysInEarthYear);
		double earthDate = year + earthYearComplete;
		double marsDate = ((8.0/15.0) * (earthDate - 1961.0)) + 1.0;
		double marsYear = Math.floor(marsDate);
		double marsDateComplete = marsDate - marsYear;
		long dayOfYearMars = Math.round(SOLS_IN_YEAR * marsDateComplete);

		return "46 Libra XXXI";
	}
}
