package test;


import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import helperModule.clientFactory;
import parkingBookingModule.ParkingLot;
import userModule.Client;
import userModule.Manager;
import userModule.SuperManager;



public class TestApplication {
	
	
	/**
	 * List of requirements/cases 
	 * 1) only 1 super manager can interact with auto generation system and create management accounts
	 * 2) Managers can add, enable, and disable parking lots and parking spaces
	 * 3) Clients must be registered, verified and logged in to book a parking space (visitor does not need verification)
	 * 4) Different clients have different parking rates per hour which should be reflected in their bills as well as different payment strategies
	 * 5) Factory creates appropriate client object based on inputs (ie: student, faculty member, etc..)
	 * 6) Clients can extend and cancel booking
	 * 7) Number of available spaces is updated according to enabled, disabled or booked parking spaces. This is accomplished using state and observer pattern
	 **/



	/**
	 * What is being tested in test case 1
	 * 1) only 1 super manager can interact with auto generation system and create management accounts
	 * 2) Managers can add, enable, and disable parking lots and parking spaces
	 * 7) Number of available spaces is updated according to enabled, disabled or booked parking spaces.
	 **/
	@Test
	public void test1() {		
		// get instance of the 1 super manager
		SuperManager superManager = SuperManager.getInstance();
		// create a manager using super manager
		Manager manager = superManager.createManagementAccount("testManager@gmail.com", "manager1", "manager128");
		assertFalse(manager.isLoggedIn());
		
		// logging in without correct credentials
		manager.login("manage", "mana");
		assertFalse(manager.isLoggedIn());
		
		// logging in with correct credentials
		manager.login("manager1", "manager128");
		assertTrue(manager.isLoggedIn());
		
		// Using Factory to create applicable user based on input (this also touched on number 5 in the list above)
		Client student = clientFactory.createClient("Student","123@no.com","student", "123", "awxj049");
		
		
		assertEquals(0, student.getAvailableSpaces().size());
		
		ParkingLot pl = manager.addParkingLot();

		assertEquals(99, student.getAvailableSpaces().size());
		
		
		manager.disableParkingLot(pl);
		
		assertEquals(0, student.getAvailableSpaces().size());
		
		manager.enableParkingLot(pl);
		
		assertEquals(99, student.getAvailableSpaces().size());
	
	
		manager.disableParkingSpace(pl.getParkingSpaces()[2]);
		
		assertEquals(98, student.getAvailableSpaces().size());
		manager.disableParkingLot(pl);
		
	}
	
	/**
	 * What is being tested in test case 2?
	 * 3) Clients must be registered, verified and logged in to book a parking space (visitor does not need verification)
	 * 5) Factory creates appropriate client object based on inputs (ie: student, faculty member, etc..)
	 *  7) Number of available spaces is updated according to enabled, disabled or booked parking spaces.
	 */
	
	@Test
	public void test2() {
		
		SuperManager superManager = SuperManager.getInstance();
		Manager manager = superManager.createManagementAccount("testManager@gmail.com", "manager1", "manager128");
		manager.login("manager1", "manager128");
		ParkingLot pl = manager.addParkingLot();
	
		// Using Factory to create applicable user based on input type
		Client student = clientFactory.createClient("Student","123@no.com","student", "123", "awxj049");
		assertEquals(99, student.getAvailableSpaces().size());
		student.register();
		student.login("student", "123");
		// student must be verified to log in (unless its a visitor)
		assertFalse(student.isLoggedIn());
		
		try {
		// this call throws an exception because the user is not logged in
		student.bookParkingSpace(student.getAvailableSpaces().get(0), 10);
		}
		catch(IllegalArgumentException e){
			
		}
		
		assertEquals(99, student.getAvailableSpaces().size());
		manager.validateAccount(student);
		
		student.login("student", "123");
		// student verified and entered correct credentials
		assertTrue(student.isLoggedIn());
		
		// test a vistor
		
		Client visitor = clientFactory.createClient("Visitor","visitor@gmail.com","visitor", "123", "awx29309");
		
		visitor.login("visitor", "123");
		// any client must register before logging in
		assertFalse(visitor.isLoggedIn());
		visitor.register();
		
		visitor.login("visitor", "123");
		// No manager verification needed
		assertTrue(visitor.isLoggedIn());
		

		
		student.bookParkingSpace(student.getAvailableSpaces().get(0), 10);
		
		assertEquals(98, student.getAvailableSpaces().size());
		
		// added this to not conflict with other test cases since parking space carry over for some reason
		manager.disableParkingLot(pl);
	}
	/**
	 * What is being tested in test case 3?
	 * 4) Different clients have different parking rates per hour which should be reflected in their bills as well as different payment strategies
	 * 5) Factory creates appropriate client object based on inputs (ie: student, faculty member, etc..)
	 * 6) Clients can extend and cancel booking
	 * 7) Number of available spaces is updated according to enabled, disabled or booked parking spaces.
	 */
	
	@Test
	public void test3() {
		
		SuperManager superManager = SuperManager.getInstance();
		Manager manager = superManager.createManagementAccount("testManager@gmail.com", "manager1", "manager128");
		manager.login("manager1", "manager128");
		ParkingLot pl = manager.addParkingLot();
	
		// Using Factory to create applicable user based on input type
		Client student = clientFactory.createClient("Student","123@test.com","student", "123", "awxj049");
		Client fm = clientFactory.createClient("Faculty Member","fm@test.com","fm", "123", "sjam840");
		Client nonfm = clientFactory.createClient("Non-faculty staff","nfm@test.com","nfm", "123", "asjdm2320");
		student.register();
		fm.register();
		nonfm.register();
		
		manager.validateAccount(nonfm);
		manager.validateAccount(student);
		manager.validateAccount(fm);
		
		student.login("student", "123");
		nonfm.login("nfm", "123");
		fm.login("fm", "123");
		
		// clients verified and entered correct credentials
		assertTrue(student.isLoggedIn());
		assertTrue(nonfm.isLoggedIn());
		assertTrue(fm.isLoggedIn());
		// test a vistor
		Client visitor = clientFactory.createClient("Visitor","visitor@gmail.com","visitor", "123", "awx29309");
		visitor.register();
		visitor.login("visitor", "123");
		// No manager verification needed
		assertTrue(visitor.isLoggedIn());

		
		student.bookParkingSpace(student.getAvailableSpaces().get(0), 10);
		fm.bookParkingSpace(fm.getAvailableSpaces().get(1), 10);
		nonfm.bookParkingSpace(nonfm.getAvailableSpaces().get(2), 10);
		visitor.bookParkingSpace(visitor.getAvailableSpaces().get(3), 10);
		assertEquals(95, student.getAvailableSpaces().size());
		
		
		// each client gets charged differently for the same 10 hours booked
		assertEquals("Payment with Debit Card of 150", visitor.pay("Debit"));
		assertEquals("Payment with Credit Card of 50", student.pay("Credit"));
		assertEquals("Payment with mobile of 80", fm.pay("Mobile"));
		assertEquals("Payment with Debit Card of 100", nonfm.pay("Debit"));
		
		// added this to not conflict with other test cases since parking space carry over for some reason
				manager.disableParkingLot(pl);
		
	}
	/**
	 * What is being tested in test case 4?
	 * 6) Clients can extend and cancel booking
	 */
	@Test
	public void test4() {
		
		SuperManager superManager = SuperManager.getInstance();
		Manager manager = superManager.createManagementAccount("testManager@gmail.com", "manager1", "manager128");
		manager.login("manager1", "manager128");
	
		// Using Factory to create applicable user based on input type
		Client student = clientFactory.createClient("Student","123@test.com","student", "123", "awxj049");
	
		
		student.register();

		manager.validateAccount(student);
	
		
		student.login("student", "123");
	
		assertTrue(student.isLoggedIn());
	
		student.bookParkingSpace(student.getAvailableSpaces().get(0), 10);
		
		assertEquals(10, student.getBookedHours());
		
		student.extendBooking(5);
		
		assertEquals(15, student.getBookedHours());
		
		student.cancelBooking();
		// client must still be charged for 1 hour even if cancelled booking
		assertEquals(1, student.getBookedHours());
		
		
	}
	
	
}
