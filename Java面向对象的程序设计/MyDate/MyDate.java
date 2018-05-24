
/**
 * Class MyDate
 */
class MyDate {

	private int year, month, day;  			// private properties

	// static variables 
	private static String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", 
											"Aug", "Sep", "Oct", "Nov", "Dec"};
	private static String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday", 
											"Thursday", "Friday", "Saturday"};
	private static int[] dayInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	/**
	 * Constructor.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:33:36+0800
	 * @param    year                     default year
	 * @param    month                    default month
	 * @param    day                      default day
	 */
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		if (MyDate.isLeapYear(this.year) == true) 
			dayInMonths[1] = 29;
	}


	/**
	 * Certificate whether the given year is a leap year.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:34:16+0800
	 * @param    year                     the year given
	 * @return                            whether the given year is a leap year
	 */
	public static boolean isLeapYear(int year) {
		if (year % 400 == 0) 	return true;
		else if (year % 4 == 0 && year % 100 != 0) return true;
		else 	return false;
	}

	/**
	 * Certificate whether the given date is valid.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:35:25+0800
	 * @param    year                     the given year
	 * @param    month                    the given month
	 * @param    day                      the given day
	 * @return                            whether the given date is valid
	 */
	public static boolean isValidDate(int year, int month, int day) {
		if (year < 1 || year > 9999) 	return false;
		if (month < 1 || month > 12)	return false;
		if (day < 1 || day > MyDate.dayInMonths[month - 1])	return false;
		return true;
	}

	/**
	 * Get the day of the given date.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:36:24+0800
	 * @see      https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week
	 * @param    year                     the given year
	 * @param    month                    the given month
	 * @param    day                      the given day
	 * @return                            the day of the given date
	 */
	public static int getDayOfWeek(int year, int month, int day) {
		int Y = (month < 3)? year - 1 : year;
		int y = Y % 100;
		int c = Y / 100;
		int d = day;
		int m = month - 2;
		if (m < 1) 	m += 12;
		int w = (int) (d + Math.floor(2.6 * m - 0.2) + Y + Math.floor(Y / 4) + Math.floor(c / 4) - 2 * c) % 7;
		w -= 1;
		if (w < 0) w += 7;
		return w;
	}

	/**
	 * Set the given date.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:38:10+0800
	 * @param    year                     the given year
	 * @param    month                    the given month
	 * @param    day                      the given day
	 * @return                            true if the date given is valid
	 */
	public boolean setDate(int year, int month, int day) {
		if (isValidDate(year, month, day) == false)	return false;
		this.year = year;
		this.month = month;
		this.day = day;
		return true;
	}

	/**
	 * Set the given year.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:38:10+0800
	 * @param    year                     the given year
	 * @return                            true if the year given is valid
	 */
	public boolean setYear(int year) {
		if (year < 1 || year > 9999) 	return false;
		this.year = year;
		return true;
	}

	/**
	 * Set the given month.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:38:10+0800
	 * @param    month                    the given month
	 * @return                            true if the month given is valid
	 */
	public boolean setMonth(int month) {
		if (month < 1 || month > 12)	return false;
		this.month = month;
		return true;
	}

	/**
	 * Set the given day.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:38:10+0800
	 * @param    day                      the given day
	 * @return                            true if the day given is valid
	 */
	public boolean setDay(int day) {
		if (day < 1 || day > MyDate.dayInMonths[month - 1])	return false;
		this.day = day;
		return true;
	}

	/**
	 * Get the year of date.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:40:37+0800
	 * @return   the year of date
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Get the month of date.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:40:37+0800
	 * @return   the month of date
	 */
	public int getMonth() {
		return this.month;
	}

	/**
	 * Get the day of date.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:40:37+0800
	 * @return   the day of date
	 */
	public int getDay() {
		return this.day;
	}

 	/**
 	 * Transform the date to the formatted string.
 	 * @Author   NinoLau
 	 * @DateTime 2017-10-07T16:41:28+0800
 	 * @return   fomatted string
 	 */
	public String toString() {
		String dow = strDays[getDayOfWeek(this.year, this.month, this.day)];
		String d = Integer.toString(this.day);
		String m = strMonths[this.month - 1];
		String y = Integer.toString(this.year);
		String re = dow + " " + d + " " + m + " " + y;
		return re;
	}

	/**
	 * The date adder of day.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:41:58+0800
	 * @return   the added day
	 */
	public MyDate nextDay() {
		if (this.month == 12 && this.day == 31) {
			this.year++;
			this.month = 1;
			this.day = 1;
			return this;
		}
		else if (this.day == this.dayInMonths[month - 1]) {
			this.month++;
			this.day = 1;
			return this;
		}
		else 	this.day++;
		return 	this;
	}

	/**
	 * The date adder of month.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:42:42+0800
	 * @return   the added day
	 */
	public MyDate nextMonth() {
		if (this.month == 12) {
			this.year++;
			this.month = 1;
			return this;
		}
		else {
			this.month++;
			if (this.day > this.dayInMonths[this.month - 1]) {
				this.day = this.dayInMonths[this.month - 1];
			}
			return this;
		}
	}

	/**
	 * The date adder of year.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:42:42+0800
	 * @return   the added day
	 */
	public MyDate nextYear() {
		if (MyDate.isLeapYear(this.year) == true 
				&& this.month == 2 && this.day == 29) {
			this.year++;
		    this.day--;
		    return this;
		}
		else {
			this.year++;
			return this;
		}
	}

	/**
	 * The date subtractor of day.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:42:42+0800
	 * @return   the subtracted day
	 */
	public MyDate previousDay() {
		if (this.month == 1 && this.day == 1) {
			this.year--;
			this.month = 12;
			this.day = 31;
			return this;
		}
		else if (this.day == 1) {
			this.month--;
			this.day = dayInMonths[month - 1];
			return this;
		}
		else {
			this.day--;
			return this;
		}
	}

	/**
	 * The subtractor of month.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:43:49+0800
	 * @return   the subtracted day
	 */
	public MyDate previousMonth() {
		if (this.month == 1) {
			this.year--;
			this.month = 12;
			return this;
		}
		else { 
			this.month--;
			if (this.day > this.dayInMonths[this.month - 1]) {
				this.day = this.dayInMonths[this.month - 1];
			}
			return this;
		}
	}

	/**
	 * The subtractor of year.
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:43:49+0800
	 * @return   the subtracted day
	 */
	public MyDate previousYear() {
		if (MyDate.isLeapYear(this.year) == true
				&& this.day == 29 && this.month == 2) {
			this.year--;
			this.day--;
			return this;
		}
		else {
			this.year--;
			return this;
		}
	}

	/**
	 * Unit Test
	 * @Author   NinoLau
	 * @DateTime 2017-10-07T16:45:08+0800
	 * @param    args                     inutility
	 */
	public static void main(String[] args) {

		// test 1
		System.out.println("\n************ d1 *************");
		MyDate d1 = new MyDate(2017, 10 ,31);
		System.out.println(d1.toString());
		System.out.println(d1.nextDay().toString());
		System.out.println(d1.nextDay().toString());
		System.out.println(d1.nextMonth().toString()); 
		System.out.println(d1.nextYear().toString());
		System.out.println("*****************************\n");

		// test 2
		System.out.println("\n************ d2 *************");
		MyDate d2 = new MyDate(2012, 1, 2);
		System.out.println(d2.toString());
		System.out.println(d2.previousDay().toString()); 
		System.out.println(d2.previousDay().toString()); 
		System.out.println(d2.previousMonth().toString()); 
		System.out.println(d2.previousYear().toString());
		System.out.println("*****************************\n");

		// test 3
		System.out.println("\n************ d3 *************");
		MyDate d3 = new MyDate(2012, 2, 29);
		System.out.println(d3.previousYear().toString());
		System.out.println("*****************************\n");

 		// loop test
		System.out.println("\n*********** loop ***********");
		MyDate d4 = new MyDate(2011, 12, 27);
		while (d4.getYear() != 2012 || d4.getMonth() != 3 || d4.getDay() != 2)
			System.out.println(d4.nextDay().toString());
		System.out.println("*****************************\n");
	}
}