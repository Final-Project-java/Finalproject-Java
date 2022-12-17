// Mohammed Abdul Sajeel Id: 212256020 email: smohammedabdul1@toromail.csudh.edu
// Lokesh purohit        Id: 212247895 email: lpurohit1@toromail.csudh.edu
// Mohammed Shoaibuddin  Id: 212255734 email: smohammed7@toromail.csudh.edu
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Age {

	public static boolean IsAdult (String DOB) throws ParseException {

		Calendar today = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		java.util.Date userDOB=null;
		try{
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			userDOB = df.parse(DOB);
			dob.setTime(userDOB);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Please provide a valid date");

		}
		

		int birthYear = dob.get(Calendar.YEAR);
		int thisYear = today.get(Calendar.YEAR);

		if((thisYear - birthYear) >= 18) return true;
		else return false;



	}
}
