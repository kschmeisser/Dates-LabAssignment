/**
 * DateRange will take the first date and the second date and return them
 * as a proper toString format
 */
public class DateRange
{
	
	Date start, end;
	
	/**
	 * @param first
	 * @param last
	 */
	public DateRange(Date first, Date last)
	{
		start = first;
		end = last;
	}//end DateRange
	
	/**
	 * Output into a proper format
	 */
	public String toString() 
	{
		return "DateRange: " + start.toString() + " - " + end.toString();
	}
}