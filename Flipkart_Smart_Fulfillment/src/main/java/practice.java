import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class practice {
	
	 public static void main(String[] args) throws  Exception {
		 Date date = Calendar.getInstance().getTime();
 		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm");
 		String strDate = dateFormat.format(date);
 		System.out.println(strDate);
	 }
}
