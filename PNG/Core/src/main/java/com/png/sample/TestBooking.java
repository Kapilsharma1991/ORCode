/**
 * 
 */
package com.png.sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.png.base.BaseConstants;
import com.png.reservation.Entity.Booking;

/**
 * @author Manish Arora
 *
 */
public class TestBooking {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String uStart = "06-04-2016";
		String uEnd = "24-04-2016";
		
		Booking b1 = new Booking(0);
		b1.setStartDate("24-03-2016");
		b1.setEndDate("27-03-2016");
		
		Booking b2 = new Booking(0);
		b2.setStartDate("28-03-2016");
		b2.setEndDate("29-03-2016");
		
		Booking b3 = new Booking(0);
		b3.setStartDate("04-04-2016");
		b3.setEndDate("06-04-2016");
		
		Booking b4 = new Booking(0);
		b4.setStartDate("01-04-2016");
		b4.setEndDate("02-04-2016");
		
		List<Booking> unsortedBookings = new ArrayList<Booking>();
		unsortedBookings.add(b1);
		unsortedBookings.add(b3);
		unsortedBookings.add(b2);
		unsortedBookings.add(b4);
		
		System.out.println(unsortedBookings.get(0).getStartDate()+","+unsortedBookings.get(1).getStartDate()+","+unsortedBookings.get(2).getStartDate()+","+unsortedBookings.get(3).getStartDate());
		
		Collections.sort(unsortedBookings);
		
		System.out.println(unsortedBookings.get(0).getStartDate()+","+unsortedBookings.get(1).getStartDate()+","+unsortedBookings.get(2).getStartDate()+","+unsortedBookings.get(3).getStartDate());
		
		SimpleDateFormat df = new SimpleDateFormat(BaseConstants.DATE_FORMAT);
		
		boolean avail = false;
		try {
			
			int size = unsortedBookings.size();
			Date UED = df.parse(uEnd);
			Date USD = df.parse(uStart);
			if ((UED.compareTo(df.parse(unsortedBookings.get(0).getStartDate())) <=0 ) || (USD.compareTo(df.parse(unsortedBookings.get(size-1).getEndDate())) >=0)){
				avail = true;
				System.out.println("avail: "+avail+" for "+ uStart+" to "+uEnd);
				return;
			}
			
			//if (df.p)
			for (int i = 1; i< unsortedBookings.size(); i++) {
				
				Date ped = df.parse(unsortedBookings.get(i-1).getEndDate());
				Date nsd = df.parse(unsortedBookings.get(i).getStartDate());
				
				if ((USD.compareTo(ped) >=0 ) && (UED.compareTo(nsd) <=0)) {
					avail=true;
					break;
				}
				
			}
			
			System.out.println("avail: "+avail+" for "+ uStart+" to "+uEnd);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

	}

}


