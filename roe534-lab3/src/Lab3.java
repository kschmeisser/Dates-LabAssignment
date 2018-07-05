import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lab 3 is to take dates from a file and out put the dates in a range
 * and test for invalid dates
 * 
 * @author Katelyn Schmeisser
 *
 */
public class Lab3
{
	/**
	 * The main function is responsible for the input of data from the file
	 * and the creation of the objects
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Date[] date = new Date[10];
		int counter = 0;
		
		Scanner in = null;
		try 
		{
		    in = new Scanner(new File("dates.txt"));
		} 
		catch (FileNotFoundException exception) 
		{
		    System.err.println("failed to open dates.txt");
		    System.exit(1);
		}
		
		//While there is more stuff in the file
		while (in.hasNextLine())
		{
		    String line = in.nextLine();
		    date[counter] = new Date(line);
		    System.out.println(date[counter].toString());
		    //If the current date and the previous date were within a valid time frame
		    // create a DateRange object
		    if(counter >= 1 && date[counter].compareTo(date[counter-1]) > 0)
		    {
		    	DateRange range = new DateRange(date[counter-1], date[counter]);
		    	System.out.println(range.toString());
		    }
		    //Increment counter so that each date will be tested with the previous date
		    counter++;
		}
		
		//Close file
		in.close();
		
	}//END main()
}//END Lab3