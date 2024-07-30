import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
	String passengerName;
	int trainNo;
	Date date;
	
	Booking(Scanner scanner){
		System.out.println("Enter Name of Passenger:");
		passengerName=scanner.nextLine();
		
		//validate input Train num
		while(true) {
			System.out.println("Enter Train Number:");
			if(scanner.hasNextInt()) {
				trainNo=scanner.nextInt();
				scanner.nextLine(); // consume the newline character left by nextInt()
				break;
			}else {
				System.out.println("Invalid Input,Please Enter a valid train Number");
				scanner.nextLine();
			}
		}
		System.out.println("Enter date dd-mm-yyyy");
		String dateInput = scanner.nextLine();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public boolean isAvailable() throws SQLException{
		TrainDAO traindao=new TrainDAO();
		BookingDAO bookingdao=new BookingDAO();
		int capacity = traindao.getCapacity(trainNo);
		int booked = bookingdao.getBookedCount(trainNo, date);
		return booked < capacity;


		
	}

}
