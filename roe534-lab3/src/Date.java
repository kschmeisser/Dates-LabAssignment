
import java.util.StringTokenizer;

/**
 * Creates the Date Object
 * 
 *
 */
public class Date implements Comparable<Date>{
	
	private String monthName;
	private int monthNumber;
	private int day;
	public int year;
	
	/**
	 * Date constructor
	 * @param line
	 */
	public Date(String line)
	{
		StringTokenizer tokens = new StringTokenizer(line, ", ");
		
		String tokenizeMonth = tokens.nextToken();           //String token of the month
		String month = tokenizeMonth.substring(0,3);         //First 3 characters of the month token
		String fullMonth = null;
		int numMonth = 0;                                    //Number value of the month
		int iDay = Integer.parseInt(tokens.nextToken());     //turns the token into a day int
		int iYear = Integer.parseInt(tokens.nextToken());    //turns the token into a year int
		int maxDays = 0;                                     //How many days are in a specific month
		
		switch (month){
	    case "Jan": 
	        numMonth = 1;
	        maxDays = 31;
	        fullMonth = "January";
	        break;
	    case "Feb": 
	        numMonth = 2;
	        maxDays = 29;
	        fullMonth = "February";
	        break;
	    case "Mar": 
	        numMonth = 3;
	        maxDays = 31;
	        fullMonth = "March";
	        break;
	    case "Apr": 
	        numMonth = 4;
	        maxDays = 30;
	        fullMonth = "April";
	        break;
	    case "May": 
	        numMonth = 5;
	        maxDays = 31;
	        fullMonth = "May";
	        break;
	    case "Jun": 
	        numMonth = 6;
	        maxDays = 30;
	        fullMonth = "June";
	        break;
	    case "Jul": 
	        numMonth = 7;
	        maxDays = 31;
	        fullMonth = "July";
	        break;
	    case "Aug": 
	        numMonth = 8;
	        maxDays = 31;
	        fullMonth = "August";
	        break;
	    case "Sep": 
	        numMonth = 9;
	        maxDays = 30;
	        fullMonth = "September";
	        break;
	    case "Oct": 
	        numMonth = 10;
	        maxDays = 31;
	        fullMonth = "October";
	        break;
	    case "Nov": 
	        numMonth = 11;
	        maxDays = 30;
	        fullMonth = "November";
	        break;
	    case "Dec": 
	        numMonth = 12;
	        maxDays = 31;
	        fullMonth = "Decemeber";
	        break;
	    default:
	        break;
	    }
		
		//Check to make sure that the days are in range
        if (iDay <= 0 || iDay > maxDays)
        {
        	numMonth = 0;
        	day = 0;
        	year = 0;
        }
        else
        {
        	monthName = fullMonth;
        	monthNumber = numMonth;
        	day = iDay;
        	year = iYear;
        }
	}//END Date(String line)
	
	
	/**
	 * return -1 if this Date is before the other Date
	 * return 0 if they are equal
	 * return +1 if this Date is after the other Date
	 */
	public int compareTo(Date previous)
	{
		int compare = -1;
		
		//if year = 0
		if(year == 0 || previous.year == 0){
			compare = -1;
		}
		
		//if year = previous year
		else if(year == previous.year)
		{
			//if month is less than previous month
			if(monthNumber < previous.monthNumber)
			{
				compare = -1;
			}
			//if month > previous month
			if(monthNumber > previous.monthNumber)
			{
				compare = 1;
			}
			//if month = previous month
			if(monthNumber == previous.monthNumber)
			{
				//if day < previous day
				if(day < previous.day)
				{
					compare = -1;
				}
				//if day = previous day
				if(day == previous.day)
				{
					compare = 0;
				}
				//if day > previous day
				if(day > previous.day)
				{
					compare = 1;
				}
			}
		}
		
		//if year > previous year
		else if(year > previous.year)
		{
			compare = 1;
		}
		
		//if year < previous year
		else if(year < previous.year)
		{
			compare = -1;
		}
		return compare;
	}//END compareTo(Date previous)
	
	
	/**
	 * returns an Invalid date string if the date is invalid
	 * if date is correct return info into proper format
	 */
	public String toString() 
	{		
		if(year == 0)
		{
			return "Invalid Date";
		}
		else
		{
			return "Date: " + monthName + " " + day + ", " + year;
		}
	}//END toString()
	
}//END Date.java