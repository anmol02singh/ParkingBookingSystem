package clientModule;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import helperModule.clientFactory;
import parkingBookingModule.Booking;
import parkingBookingModule.BookingSystem;
import parkingBookingModule.ParkingLot;
import parkingBookingModule.ParkingSpace;
import parkingBookingModule.Sensor;
import userModule.*;



public class ParkingBookingSystemClient implements ActionListener{

	
	static int hoursBooked;

	// Default
	JFrame frame1 = new JFrame();
	JFrame frame2 = new JFrame();
	JFrame frame3 = new JFrame();
	JFrame frame4 = new JFrame();
	JFrame frame5 = new JFrame();
	JFrame frame6 = new JFrame();
	JFrame frame7 = new JFrame();
	JFrame frame8 = new JFrame();
	

	JButton register = new JButton("Register");
	JButton Login = new JButton("Login");
	JButton Book = new JButton("Book");
	JButton Extend = new JButton("Extend");
	JButton Pay2 = new JButton("Choose Payment type");
	JButton Pay = new JButton("Pay");
	JButton Cancel = new JButton("Cancel");
	JButton Choose = new JButton("Choose Extended hours");


	JToggleButton student = new JToggleButton("Student");
	JToggleButton fm = new JToggleButton("Faculty Member");
	JToggleButton nfs = new JToggleButton("Non-faculty Staff");
	JToggleButton v = new JToggleButton("Visitor");


	JToggleButton credit = new JToggleButton("Credit");
	JToggleButton debit = new JToggleButton("Debit");
	JToggleButton mobile = new JToggleButton("Mobile");


	JToggleButton time1 = new JToggleButton("1 Hour"); 
	JToggleButton time2 = new JToggleButton("2 Hours"); 
	JToggleButton time3 = new JToggleButton("3 Hours"); 
	JToggleButton time4 = new JToggleButton("4 Hours");
	
	JToggleButton Time1 = new JToggleButton("1 Hour");
	JToggleButton Time2 = new JToggleButton("2 Hours"); 
	JToggleButton Time3 = new JToggleButton("3 Hours"); 
	JToggleButton Time4 = new JToggleButton("4 Hours"); 
	JToggleButton Time5 = new JToggleButton("5 Hours");
	JToggleButton Time6 = new JToggleButton("6 Hours"); 
	JToggleButton Time7 = new JToggleButton("7 Hours"); 


	JToggleButton Spot1;
	JToggleButton Spot2;
	JToggleButton Spot3; 
	JToggleButton Spot4;
	JToggleButton Spot5;
	JToggleButton Spot6;
	Client user;

	SuperManager superManager = SuperManager.getInstance();
	Manager manager = superManager.createManagementAccount("manager@gmail.com", "manager", "manager");
	BookingSystem bookingSystem = BookingSystem.getInstance();
	Booking userBooking;
	public ParkingBookingSystemClient() {
		
		/////////////////////////// FRAME 1 (Registration) ///////////////////////////////////////////
		

		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(300, 90, 900, 600);
		frame1.setTitle("Yorku Parking Booking System");

		frame1.setResizable(false);

		Container c = frame1.getContentPane();
		c.setLayout(null);
		frame1.getContentPane().setBackground(new java.awt.Color(227, 24, 55));

		JLabel title = new JLabel("Account Registeration");
		title.setFont(new Font("Arial", Font.BOLD, 25));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		title.setBackground(Color.red);
		c.add(title);

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setSize(100, 20);
		name.setLocation(300, 100);
		c.add(name);

		JTextField tname = new JTextField();
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		tname.setSize(190, 20);
		tname.setLocation(366, 100);
		c.add(tname);
		

		JLabel plate = new JLabel("Licence Plate:");
		plate.setFont(new Font("Arial", Font.PLAIN, 20));
		plate.setSize(300, 20);
		plate.setLocation(235, 200);
		c.add(plate);

		JTextField tplate = new JTextField();
		tplate.setFont(new Font("Arial", Font.PLAIN, 15));
		tplate.setSize(190, 20);
		tplate.setLocation(366, 200);
		c.add(tplate);

		JLabel mail = new JLabel("Email:");
		mail.setFont(new Font("Arial", Font.PLAIN, 20));
		mail.setSize(100, 20);
		mail.setLocation(304, 150);
		c.add(mail);

		JTextField tmail = new JTextField();
		tmail.setFont(new Font("Arial", Font.PLAIN, 15));
		tmail.setSize(190, 20);
		tmail.setLocation(366, 150);
		c.add(tmail);
		

		JLabel pass = new JLabel("Password:");
		pass.setFont(new Font("Arial", Font.PLAIN, 20));
		pass.setSize(100, 20);
		pass.setLocation(265, 250);
		c.add(pass);

		JTextField tpass = new JTextField();
		tpass.setFont(new Font("Arial", Font.PLAIN, 15));
		tpass.setSize(190, 20);
		tpass.setLocation(366, 250);
		c.add(tpass);
		


		JLabel client = new JLabel("Client:");
		client.setFont(new Font("Arial", Font.PLAIN, 20));
		client.setSize(100, 20);
		client.setLocation(85, 310);
		c.add(client);

		// JButton student = new JButton("Student");
		student.setFont(new Font("Arial", Font.PLAIN, 15));
		student.setSelected(false);
		student.setBounds(150, 290, 150, 70);
		student.setOpaque(true);
		student.setContentAreaFilled(true);
		student.setBorderPainted(false);
		student.setFocusPainted(false);
		student.setBackground(new java.awt.Color(214, 207, 202));
		student.setForeground(new java.awt.Color(129, 0, 1));
		student.addActionListener(this);
		c.add(student);
		// JButton fm = new JButton("Faculty Member");
		fm.setFont(new Font("Arial", Font.PLAIN, 15));
		fm.setSelected(false);
		fm.setBounds(310, 290, 150, 70);
		fm.setOpaque(true);
		fm.setContentAreaFilled(true);
		fm.setBorderPainted(false);
		fm.setFocusPainted(false);
		fm.setBackground(new java.awt.Color(214, 207, 202));
		fm.setForeground(new java.awt.Color(129, 0, 1));
		fm.addActionListener(this);
		c.add(fm);

		//  JButton nfs = new JButton("NF staff");
		nfs.setFont(new Font("Arial", Font.PLAIN, 15));
		nfs.setSelected(false);
		nfs.setBounds(470, 290, 200, 70);
		nfs.setOpaque(true);
		nfs.setContentAreaFilled(true);
		nfs.setBorderPainted(false);
		nfs.setFocusPainted(false);
		nfs.setBackground(new java.awt.Color(214, 207, 202));
		nfs.setForeground(new java.awt.Color(129, 0, 1));
		nfs.addActionListener(this);
		c.add(nfs);

		//   JButton v = new JButton("Visitor");
		v.setFont(new Font("Arial", Font.PLAIN, 15));
		v.setSelected(false);
		v.setBounds(680, 290, 150, 70);
		v.setOpaque(true);
		v.setContentAreaFilled(true);
		v.setBorderPainted(false);
		v.setFocusPainted(false);
		v.setBackground(new java.awt.Color(214, 207, 202));
		v.setForeground(new java.awt.Color(129, 0, 1));
		v.addActionListener(this);
		c.add(v);

		// register button
		register.setFont(new Font("Arial", Font.BOLD, 15));
		register.setBounds(300, 390, 300, 70);
		register.setOpaque(true);
		register.setContentAreaFilled(true);
		register.setBorderPainted(false);
		register.setFocusPainted(false);
		register.setBackground(new java.awt.Color(214, 207, 202));
		register.setForeground(new java.awt.Color(129, 0, 1));

		c.add(register);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(student);
		bg.add(fm);
		bg.add(nfs);
		bg.add(v);
		student.setActionCommand("Student"); 
		fm.setActionCommand("Faculty Member");
		nfs.setActionCommand("Non-Faculty Staff");
		v.setActionCommand("Visitor");
		
		
		MouseAdapter registerButtonListener = new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);

				user = clientFactory.createClient(bg.getSelection().getActionCommand(), tmail.getText(),tname.getText(), tpass.getText(), tplate.getText());
				user.register();
				manager.validateAccount(user);
				if(user.isVerified()) {
					frame2.setVisible(true);
					frame1.dispose();
				}

			}
		};
		register.addMouseListener(registerButtonListener);
	
	



		/////////////////////////// FRAME 2 (LOGIN) ///////////////////////////////////////////


		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setBounds(300, 90, 900, 600);
		frame2.setTitle("Yorku Parking Booking System");

		frame2.setResizable(false);
		Container c2 = frame2.getContentPane();
		c2.setLayout(null);
		frame2.getContentPane().setBackground(new java.awt.Color(227, 24, 55));


		JLabel title2 = new JLabel("Login");
		title2.setFont(new Font("Arial", Font.BOLD, 25));
		title2.setSize(330, 30);
		title2.setLocation(410, 140);
		c2.add(title2);

		JLabel name2 = new JLabel("Name:");
		name2.setFont(new Font("Arial", Font.PLAIN, 20));
		name2.setSize(100, 20);
		name2.setLocation(300, 200);
		c2.add(name2);

		JTextField tname2 = new JTextField();
		tname2.setFont(new Font("Arial", Font.PLAIN, 15));
		tname2.setSize(190, 20);
		tname2.setLocation(366, 200);
		c2.add(tname2);

		JLabel pass2 = new JLabel("Password:");
		pass2.setFont(new Font("Arial", Font.PLAIN, 20));
		pass2.setSize(100, 20);
		pass2.setLocation(265, 250);
		c2.add(pass2);

		JTextField tpass2 = new JTextField();
		tpass2.setFont(new Font("Arial", Font.PLAIN, 15));
		tpass2.setSize(190, 20);
		tpass2.setLocation(366, 250);
		c2.add(tpass2);



		Login.setFont(new Font("Arial", Font.PLAIN, 15));
		Login.setBounds(390, 300, 120, 70);
		Login.setOpaque(true);
		Login.setContentAreaFilled(true);
		Login.setBorderPainted(false);
		Login.setFocusPainted(false);
		Login.setBackground(new java.awt.Color(214, 207, 202));
		Login.setForeground(new java.awt.Color(129, 0, 1));
//		Login.addActionListener(this);
		c2.add(Login);

		MouseAdapter loginButtonListener = new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				user.login(tname2.getText(), tpass2.getText());

				System.out.println(user.isLoggedIn());
				
				
				user.getAvailableSpaces();
				if(user.isLoggedIn()) {
					frame3.setVisible(true);
					frame2.dispose();
				}
		
		

				
			}
		};
		Login.addMouseListener(loginButtonListener);

		/////////////////////////// FRAME 3 (SPOT SELECTION) ///////////////////////////////////////////


		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setBounds(300, 90, 900, 600);
		frame3.setTitle("Yorku Parking Booking System");

		frame3.setResizable(false);
		Container c3 = frame3.getContentPane();
		c3.setLayout(null);
		frame3.getContentPane().setBackground(new java.awt.Color(227, 24, 55));

		JLabel title3 = new JLabel("Book A Spot");
		title3.setFont(new Font("Arial", Font.BOLD, 25));
		title3.setSize(300, 30);
		title3.setLocation(370, 80);
		title3.setBackground(Color.red);
		c3.add(title3);
		
		manager.addParkingLot();
		ArrayList<ParkingSpace> availableSpaces = bookingSystem.getAvailableSpaces();
	
		 Spot1 = new JToggleButton(String.valueOf("Spot " + availableSpaces.get(0).getId())); 
		 Spot2 = new JToggleButton(String.valueOf("Spot " +availableSpaces.get(1).getId())); 
		 Spot3 = new JToggleButton(String.valueOf("Spot " +availableSpaces.get(2).getId())); 
		 Spot4 = new JToggleButton(String.valueOf("Spot " +availableSpaces.get(3).getId())); 
		 Spot5 = new JToggleButton(String.valueOf("Spot " +availableSpaces.get(4).getId())); 
		 Spot6 = new JToggleButton(String.valueOf("Spot " +availableSpaces.get(5).getId())); 


		Spot1.setFont(new Font("Arial", Font.PLAIN, 15));
		Spot1.setSelected(false);
		Spot1.setBounds(100, 150, 100, 70);
		Spot1.setOpaque(true);
		Spot1.setContentAreaFilled(true);
		Spot1.setBorderPainted(false);
		Spot1.setFocusPainted(false);
		Spot1.setBackground(new java.awt.Color(214, 207, 202));
		Spot1.setForeground(new java.awt.Color(129, 0, 1));
		Spot1.addActionListener(this);
		c3.add(Spot1);

		Spot2.setFont(new Font("Arial", Font.PLAIN, 15));
		Spot2.setSelected(false);
		Spot2.setBounds(220, 150, 100, 70);
		Spot2.setOpaque(true);
		Spot2.setContentAreaFilled(true);
		Spot2.setBorderPainted(false);
		Spot2.setFocusPainted(false);
		Spot2.setBackground(new java.awt.Color(214, 207, 202));
		Spot2.setForeground(new java.awt.Color(129, 0, 1));
		Spot2.addActionListener(this);
		c3.add(Spot2);

		Spot3.setFont(new Font("Arial", Font.PLAIN, 15));
		Spot3.setSelected(false);
		Spot3.setBounds(340, 150, 100, 70);
		Spot3.setOpaque(true);
		Spot3.setContentAreaFilled(true);
		Spot3.setBorderPainted(false);
		Spot3.setFocusPainted(false);
		Spot3.setBackground(new java.awt.Color(214, 207, 202));
		Spot3.setForeground(new java.awt.Color(129, 0, 1));
		Spot3.addActionListener(this);
		c3.add(Spot3);

		Spot4.setFont(new Font("Arial", Font.PLAIN, 15));
		Spot4.setSelected(false);
		Spot4.setBounds(460, 150, 100, 70);
		Spot4.setOpaque(true);
		Spot4.setContentAreaFilled(true);
		Spot4.setBorderPainted(false);
		Spot4.setFocusPainted(false);
		Spot4.setBackground(new java.awt.Color(214, 207, 202));
		Spot4.setForeground(new java.awt.Color(129, 0, 1));
		Spot4.addActionListener(this);
		c3.add(Spot4);

		Spot5.setFont(new Font("Arial", Font.PLAIN, 15));
		Spot5.setSelected(false);
		Spot5.setBounds(580, 150, 100, 70);
		Spot5.setOpaque(true);
		Spot5.setContentAreaFilled(true);
		Spot5.setBorderPainted(false);
		Spot5.setFocusPainted(false);
		Spot5.setBackground(new java.awt.Color(214, 207, 202));
		Spot5.setForeground(new java.awt.Color(129, 0, 1));
		Spot5.addActionListener(this);
		c3.add(Spot5);

		Spot6.setFont(new Font("Arial", Font.PLAIN, 15));
		Spot6.setSelected(false);
		Spot6.setBounds(700, 150, 100, 70);
		Spot6.setOpaque(true);
		Spot6.setContentAreaFilled(true);
		Spot6.setBorderPainted(false);
		Spot6.setFocusPainted(false);
		Spot6.setBackground(new java.awt.Color(214, 207, 202));
		Spot6.setForeground(new java.awt.Color(129, 0, 1));
		Spot6.addActionListener(this);
		c3.add(Spot6);
		
		JLabel Hours = new JLabel("How many hours would you like to book?");
		Hours.setFont(new Font("Arial", Font.PLAIN, 25));
		Hours.setSize(730, 30);
		Hours.setLocation(100, 250);
		Hours.setForeground(Color.BLACK);
		c3.add(Hours);
		
		Time1.setFont(new Font("Arial", Font.PLAIN, 15));
		Time1.setSelected(false);
		Time1.setBounds(50, 300, 100, 70);
		Time1.setOpaque(true);
		Time1.setContentAreaFilled(true);
		Time1.setBorderPainted(false);
		Time1.setFocusPainted(false);
		Time1.setBackground(new java.awt.Color(214, 207, 202));
		Time1.setForeground(new java.awt.Color(129, 0, 1));
		Time1.addActionListener(this);
		c3.add(Time1);

		Time2.setFont(new Font("Arial", Font.PLAIN, 15));
		Time2.setSelected(false);
		Time2.setBounds(170, 300, 100, 70);
		Time2.setOpaque(true);
		Time2.setContentAreaFilled(true);
		Time2.setBorderPainted(false);
		Time2.setFocusPainted(false);
		Time2.setBackground(new java.awt.Color(214, 207, 202));
		Time2.setForeground(new java.awt.Color(129, 0, 1));
		Time2.addActionListener(this);
		c3.add(Time2);

		Time3.setFont(new Font("Arial", Font.PLAIN, 15));
		Time3.setSelected(false);
		Time3.setBounds(290, 300, 100, 70);
		Time3.setOpaque(true);
		Time3.setContentAreaFilled(true);
		Time3.setBorderPainted(false);
		Time3.setFocusPainted(false);
		Time3.setBackground(new java.awt.Color(214, 207, 202));
		Time3.setForeground(new java.awt.Color(129, 0, 1));
		Time3.addActionListener(this);
		c3.add(Time3);

		Time4.setFont(new Font("Arial", Font.PLAIN, 15));
		Time4.setSelected(false);
		Time4.setBounds(410, 300, 100, 70);
		Time4.setOpaque(true);
		Time4.setContentAreaFilled(true);
		Time4.setBorderPainted(false);
		Time4.setFocusPainted(false);
		Time4.setBackground(new java.awt.Color(214, 207, 202));
		Time4.setForeground(new java.awt.Color(129, 0, 1));
		Time4.addActionListener(this);
		c3.add(Time4);
		
		Time5.setFont(new Font("Arial", Font.PLAIN, 15));
		Time5.setSelected(false);
		Time5.setBounds(530, 300, 100, 70);
		Time5.setOpaque(true);
		Time5.setContentAreaFilled(true);
		Time5.setBorderPainted(false);
		Time5.setFocusPainted(false);
		Time5.setBackground(new java.awt.Color(214, 207, 202));
		Time5.setForeground(new java.awt.Color(129, 0, 1));
		Time5.addActionListener(this);
		c3.add(Time5);

		Time6.setFont(new Font("Arial", Font.PLAIN, 15));
		Time6.setSelected(false);
		Time6.setBounds(650, 300, 100, 70);
		Time6.setOpaque(true);
		Time6.setContentAreaFilled(true);
		Time6.setBorderPainted(false);
		Time6.setFocusPainted(false);
		Time6.setBackground(new java.awt.Color(214, 207, 202));
		Time6.setForeground(new java.awt.Color(129, 0, 1));
		Time6.addActionListener(this);
		c3.add(Time6);

		Time7.setFont(new Font("Arial", Font.PLAIN, 15));
		Time7.setSelected(false);
		Time7.setBounds(770, 300, 100, 70);
		Time7.setOpaque(true);
		Time7.setContentAreaFilled(true);
		Time7.setBorderPainted(false);
		Time7.setFocusPainted(false);
		Time7.setBackground(new java.awt.Color(214, 207, 202));
		Time7.setForeground(new java.awt.Color(129, 0, 1));
		Time7.addActionListener(this);
		c3.add(Time7);

		// book button
		Book.setFont(new Font("Arial", Font.PLAIN, 15));
		Book.setBounds(290, 450, 300, 50);
		Book.setOpaque(true);
		Book.setContentAreaFilled(true);
		Book.setBorderPainted(false);
		Book.setFocusPainted(false);
		Book.setBackground(new java.awt.Color(214, 207, 202));
		Book.setForeground(new java.awt.Color(129, 0, 1));
		Book.addActionListener(this);
		c3.add(Book);

		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(Spot1);
		bg2.add(Spot2);
		bg2.add(Spot3);
		bg2.add(Spot4);
		bg2.add(Spot5);
		bg2.add(Spot6);
		Spot1.setActionCommand("0");
		Spot2.setActionCommand("1"); 
		Spot3.setActionCommand("2"); 
		Spot4.setActionCommand("3"); 
		Spot5.setActionCommand("4"); 
		Spot6.setActionCommand("5"); 

		ButtonGroup bg5 = new ButtonGroup();
		bg5.add(Time1);
		bg5.add(Time2);
		bg5.add(Time3);
		bg5.add(Time4);
		bg5.add(Time5);
		bg5.add(Time6);
		bg5.add(Time7);
		Time1.setActionCommand("1");
		Time2.setActionCommand("2"); 
		Time3.setActionCommand("3"); 
		Time4.setActionCommand("4"); 
		Time5.setActionCommand("5"); 
		Time6.setActionCommand("6");
		Time7.setActionCommand("7"); 


		
	
		MouseAdapter bookButtonListener = new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				userBooking = user.bookParkingSpace(bookingSystem.getAvailableSpaces().get(Integer.valueOf(bg2.getSelection().getActionCommand())), Integer.valueOf(bg5.getSelection().getActionCommand()));
				hoursBooked = userBooking.getBookedHours();
				System.out.println(bookingSystem.getAvailableSpaces().size());
//				System.out.println(user.getEmail());
//				System.out.println(bg.getSelection().getActionCommand());	
//				frame3.setVisible(true);
//				frame2.dispose();
//		

				
			}
		};
		Book.addMouseListener(bookButtonListener);


		/////////////////////////// FRAME 4 (Menu) ///////////////////////////////////////////
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setBounds(300, 90, 900, 600);
		frame4.setTitle("Yorku Parking Booking System");

		frame4.setResizable(false);
		Container c4 = frame4.getContentPane();

		
		c4.setLayout(null);
		frame4.getContentPane().setBackground(new java.awt.Color(227, 24, 55));


		JLabel title4 = new JLabel("Menu");
		title4.setFont(new Font("Arial", Font.BOLD, 25));
		title4.setSize(300, 30);
		title4.setLocation(440, 60);
		title4.setBackground(Color.red);
		c4.add(title4);

		JLabel Price = new JLabel("You have booked Spot D2 for "+ hoursBooked +" hours, you will be charged $40");
		
		Price.setFont(new Font("Arial", Font.ITALIC, 25));
		Price.setSize(730, 30);
		Price.setLocation(100, 100);
		Price.setForeground(Color.BLACK);
		c4.add(Price);

		Pay.setFont(new Font("Arial", Font.PLAIN, 15));
		Pay.setBounds(320, 160, 300, 50);
		Pay.setOpaque(true);
		Pay.setContentAreaFilled(true);
		Pay.setBorderPainted(false);
		Pay.setFocusPainted(false);
		Pay.setBackground(new java.awt.Color(214, 207, 202));
		Pay.setForeground(new java.awt.Color(129, 0, 1));
		Pay.addActionListener(this);
		c4.add(Pay);

		Extend.setFont(new Font("Arial", Font.PLAIN, 15));
		Extend.setBounds(320, 250, 300, 50);
		Extend.setOpaque(true);
		Extend.setContentAreaFilled(true);
		Extend.setBorderPainted(false);
		Extend.setFocusPainted(false);
		Extend.setBackground(new java.awt.Color(214, 207, 202));
		Extend.setForeground(new java.awt.Color(129, 0, 1));
		Extend.addActionListener(this);
		c4.add(Extend);

		Cancel.setFont(new Font("Arial", Font.PLAIN, 15));
		Cancel.setBounds(320, 330, 300, 50);
		Cancel.setOpaque(true);
		Cancel.setContentAreaFilled(true);
		Cancel.setBorderPainted(false);
		Cancel.setFocusPainted(false);
		Cancel.setBackground(new java.awt.Color(214, 207, 202));
		Cancel.setForeground(new java.awt.Color(129, 0, 1));
		Cancel.addActionListener(this);
		c4.add(Cancel);



		/////////////////////////// FRAME 5 (BILLING) ///////////////////////////////////////////


		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.setBounds(300, 90, 900, 600);
		frame5.setTitle("Yorku Parking Booking System");

		frame5.setResizable(false);
		Container c5 = frame5.getContentPane();
		c5.setLayout(null);
		frame5.getContentPane().setBackground(new java.awt.Color(227, 24, 55));


		JLabel title5 = new JLabel("Thank you! Your spot is booked!");
		title5.setFont(new Font("Arial", Font.BOLD, 25));
		title5.setSize(500, 30);
		title5.setLocation(220, 80);
		c5.add(title5);


		JLabel DOP = new JLabel("Date of purchase:                   2023/01/24");
		DOP.setFont(new Font("Arial", Font.ITALIC, 25));
		DOP.setSize(730, 30);
		DOP.setLocation(100, 150);
		DOP.setForeground(Color.BLACK);
		c5.add(DOP);

		JLabel booked = new JLabel("you have booked for:              5 Hours");
		booked.setFont(new Font("Arial", Font.ITALIC, 25));
		booked.setSize(730, 30);
		booked.setLocation(100, 190);
		booked.setForeground(Color.BLACK);
		c5.add(booked);

		JLabel hoursbooked = new JLabel("you have booked spot:           D1");
		hoursbooked.setFont(new Font("Arial", Font.ITALIC, 25));
		hoursbooked.setSize(730, 30);
		hoursbooked.setLocation(100, 310);
		hoursbooked.setForeground(Color.BLACK);
		c5.add(hoursbooked);

		JLabel moneypaid = new JLabel("you have been charged:        $45");
		moneypaid.setFont(new Font("Arial", Font.ITALIC, 25));
		moneypaid.setSize(730, 30);
		moneypaid.setLocation(100, 230);
		moneypaid.setForeground(Color.BLACK);
		c5.add(moneypaid);

		JLabel licensePlate = new JLabel("License Plate:                        BKRW 134");
		licensePlate.setFont(new Font("Arial", Font.ITALIC, 25));
		licensePlate.setSize(730, 30);
		licensePlate.setLocation(100, 270);
		licensePlate.setForeground(Color.BLACK);
		c5.add(licensePlate);


		/////////////////////////// FRAME 6 (Choose Payment type) ///////////////////////////////////////////


		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.setBounds(300, 90, 900, 600);
		frame6.setTitle("Yorku Parking Booking System");

		frame6.setResizable(false);
		Container c6 = frame6.getContentPane();
		c6.setLayout(null);
		frame6.getContentPane().setBackground(new java.awt.Color(227, 24, 55));

		JLabel Price2 = new JLabel("You have booked Spot D2 for 5 hours, you will be charged $40");
		Price2.setFont(new Font("Arial", Font.ITALIC, 25));
		Price2.setSize(730, 30);
		Price2.setLocation(100, 100);
		Price2.setForeground(Color.BLACK);
		c6.add(Price2);

		//		JLabel Price3 = new JLabel("You have cancelled and will be charged for 1 hour, you will be charged $40");
		//		Price3.setFont(new Font("Arial", Font.ITALIC, 25));
		//		Price3.setSize(730, 30);
		//		Price3.setLocation(100, 100);
		//		Price3.setForeground(Color.BLACK);
		//		c6.add(Price3);

		JLabel title6 = new JLabel("How would you like to pay?"); 
		title6.setFont(new Font("Arial", Font.BOLD, 25));
		title6.setSize(500, 30);
		title6.setLocation(340, 50);
		c6.add(title6);

		Pay2.setFont(new Font("Arial", Font.PLAIN, 15));
		Pay2.setBounds(280, 450, 400, 50);
		Pay2.setOpaque(true);
		Pay2.setContentAreaFilled(true);
		Pay2.setBorderPainted(false);
		Pay2.setFocusPainted(false);
		Pay2.setBackground(new java.awt.Color(214, 207, 202));
		Pay2.setForeground(new java.awt.Color(129, 0, 1));
		Pay2.addActionListener(this);
		c6.add(Pay2);

		credit.setFont(new Font("Arial", Font.PLAIN, 15));
		credit.setBounds(320, 160, 300, 50);
		credit.setOpaque(true);
		credit.setContentAreaFilled(true);
		credit.setBorderPainted(false);
		credit.setFocusPainted(false);
		credit.setBackground(new java.awt.Color(214, 207, 202));
		credit.setForeground(new java.awt.Color(129, 0, 1));
		credit.addActionListener(this);
		c6.add(credit);

		debit.setFont(new Font("Arial", Font.PLAIN, 15));
		debit.setBounds(320, 240, 300, 50);
		debit.setOpaque(true);
		debit.setContentAreaFilled(true);
		debit.setBorderPainted(false);
		debit.setFocusPainted(false);
		debit.setBackground(new java.awt.Color(214, 207, 202));
		debit.setForeground(new java.awt.Color(129, 0, 1));
		debit.addActionListener(this);
		c6.add(debit);

		mobile.setFont(new Font("Arial", Font.PLAIN, 15));
		mobile.setBounds(320, 330, 300, 50);
		mobile.setOpaque(true);
		mobile.setContentAreaFilled(true);
		mobile.setBorderPainted(false);
		mobile.setFocusPainted(false);
		mobile.setBackground(new java.awt.Color(214, 207, 202));
		mobile.setForeground(new java.awt.Color(129, 0, 1));
		mobile.addActionListener(this);
		c6.add(mobile);

		ButtonGroup bg3 = new ButtonGroup();
		bg3.add(credit);
		bg3.add(debit);
		bg3.add(mobile);
		credit.setActionCommand("Credit");
		debit.setActionCommand("Debit"); 
		mobile.setActionCommand("Mobile"); 
		
		MouseAdapter payButtonListener = new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println(user.pay(bg3.getSelection().getActionCommand()));
//				System.out.println(message);
				
		
			}
		};
		Pay2.addMouseListener(payButtonListener);


		/////////////////////////// FRAME 7 (Choose extension) ///////////////////////////////////////////


		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame7.setBounds(300, 90, 900, 600);
		frame7.setTitle("Yorku Parking Booking System");

		frame7.setResizable(false);
		Container c7 = frame7.getContentPane();
		c7.setLayout(null);
		frame7.getContentPane().setBackground(new java.awt.Color(227, 24, 55));


		JLabel title7 = new JLabel("How many hours would you like to extend?");
		title7.setFont(new Font("Arial", Font.BOLD, 25));
		title7.setSize(600, 30);
		title7.setLocation(200, 80);
		c7.add(title7);

		time1.setFont(new Font("Arial", Font.PLAIN, 15));
		time1.setSelected(false);
		time1.setBounds(200, 150, 100, 70);
		time1.setOpaque(true);
		time1.setContentAreaFilled(true);
		time1.setBorderPainted(false);
		time1.setFocusPainted(false);
		time1.setBackground(new java.awt.Color(214, 207, 202));
		time1.setForeground(new java.awt.Color(129, 0, 1));
		time1.addActionListener(this);
		c7.add(time1);

		time2.setFont(new Font("Arial", Font.PLAIN, 15));
		time2.setSelected(false);
		time2.setBounds(320, 150, 100, 70);
		time2.setOpaque(true);
		time2.setContentAreaFilled(true);
		time2.setBorderPainted(false);
		time2.setFocusPainted(false);
		time2.setBackground(new java.awt.Color(214, 207, 202));
		time2.setForeground(new java.awt.Color(129, 0, 1));
		time2.addActionListener(this);
		c7.add(time2);

		time3.setFont(new Font("Arial", Font.PLAIN, 15));
		time3.setSelected(false);
		time3.setBounds(440, 150, 100, 70);
		time3.setOpaque(true);
		time3.setContentAreaFilled(true);
		time3.setBorderPainted(false);
		time3.setFocusPainted(false);
		time3.setBackground(new java.awt.Color(214, 207, 202));
		time3.setForeground(new java.awt.Color(129, 0, 1));
		time3.addActionListener(this);
		c7.add(time3);

		time4.setFont(new Font("Arial", Font.PLAIN, 15));
		time4.setSelected(false);
		time4.setBounds(560, 150, 100, 70);
		time4.setOpaque(true);
		time4.setContentAreaFilled(true);
		time4.setBorderPainted(false);
		time4.setFocusPainted(false);
		time4.setBackground(new java.awt.Color(214, 207, 202));
		time4.setForeground(new java.awt.Color(129, 0, 1));
		time4.addActionListener(this);
		c7.add(time4);


		Choose.setFont(new Font("Arial", Font.PLAIN, 15));
		Choose.setBounds(300, 300, 300, 50);
		Choose.setOpaque(true);
		Choose.setContentAreaFilled(true);
		Choose.setBorderPainted(false);
		Choose.setFocusPainted(false);
		Choose.setBackground(new java.awt.Color(214, 207, 202));
		Choose.setForeground(new java.awt.Color(129, 0, 1));
		Choose.addActionListener(this);
		c7.add(Choose);


		ButtonGroup bg4 = new ButtonGroup();
		bg4.add(time1);
		bg4.add(time2);
		bg4.add(time3);
		bg4.add(time4);
		time1.setActionCommand("1");
		time2.setActionCommand("2");
		time3.setActionCommand("3");
		time4.setActionCommand("4");


		
		frame7.setVisible(false);
		frame6.setVisible(false);
		frame5.setVisible(false);
		frame4.setVisible(false);
		frame3.setVisible(false);
		frame2.setVisible(false);
		frame1.setVisible(true);

	}	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == register) {
			frame2.setVisible(true);
			frame1.dispose();
		}
		if (e.getSource() == Login) {
			frame3.setVisible(true);
			frame2.dispose();
		}
		if (e.getSource() == Book) {
			frame4.setVisible(true);
			frame3.dispose();
		}
		if (e.getSource() == Pay) {
			frame6.setVisible(true);
			frame4.dispose();
		}
		if (e.getSource() == Extend) {
			frame7.setVisible(true);
			frame4.dispose();	
		}
		if (e.getSource() == Choose) {
			frame4.setVisible(true);
			frame7.dispose();
		}
		if (e.getSource() == Cancel) {
			frame6.setVisible(true);
			frame4.dispose();
		}
		if (e.getSource() == Pay2) {
			frame5.setVisible(true);
			frame6.dispose();
		}
	}



	public static void main(String[] args) {





	
		//this is GUI
		new ParkingBookingSystemClient();
		
		// Singleton
		BookingSystem bookingSystem = BookingSystem.getInstance();
		// Using Factory to create applicable user based on input
		Client student = clientFactory.createClient("Student","123@no.com","student", "123", "awxj049");

		SuperManager superManager = SuperManager.getInstance();
		Manager manager = superManager.createManagementAccount("testManager@gmail.com", "manager1", "manager128");

		System.out.println(manager.isLoggedIn());
		// need correct credentials to have loggedIn status;
		manager.login("manager1", "manager128");
		System.out.println(manager.isLoggedIn());
		System.out.println(manager.getTeam());

		// student must register before they can be verified
		student.register();
		// All fields must not be blank to be verified
		manager.validateAccount(student);
		System.out.println(student.isLoggedIn());
		student.login("student", "123");
		System.out.println(student.isLoggedIn());

	

		
		Client prof1 = clientFactory.createClient("Faculty Member","mokhtar@eecs.ca","Mokhtar", "Mokhtar1", "awxj049");
		prof1.register();
		
		manager.validateAccount(prof1);
		prof1.login("Mokhtar", "Mokhtar1");
		

		ParkingLot parkingLot = manager.addParkingLot();
		
		
		
		// display these spaces in GUI
		System.out.println(student.getAvailableSpaces());

		
//		student1.bookParkingSpace(student1.getAvailableSpaces().get(0), 10);
		//System.out.println(prof1.getAvailableSpaces().size());
	
		prof1.bookParkingSpace(prof1.getAvailableSpaces().get(4), 9);
		
	
		
		
	
		

		
		System.out.println(prof1.pay("Debit"));
		

	
		// client chooses one 
		// on event click then call client.bookParkingSpace
		
		
		student.bookParkingSpace(bookingSystem.getAvailableSpaces().get(0), 10);
		System.out.println(student.pay("Credit"));
		
		System.out.println(student.getBookedHours());

		student.extendBooking(4);
		System.out.println(student.getBookedHours());
		
		student.cancelBooking();
		System.out.println(student.getBookedHours());
	
		manager.disableParkingLot(parkingLot);
		
		// unable to book because lot is disabled (throws exception)
		student.bookParkingSpace(bookingSystem.getAvailableSpaces().get(0), 10);
		



		

	}
}
