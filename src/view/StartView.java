package view;

import controller.Controller;

public class StartView {

	public static void main(String[] args) {
		Controller con = new Controller();
		
//		con.showAllCustomer();
//		
//		con.showCustomer("NOA");
//		con.showCustomer(101);
		
		con.login("KIN");
		
//		con.signin("PEA", 300);
//		con.signin("BEE", 600);
//		con.signin("KIN", null);
		
		con.showAllCustomer();
		
//		con.login("PEA");
//		con.login("BEE");
//		con.login("KIN");
	}

}
