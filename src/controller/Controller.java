package controller;

import java.util.ArrayList;

import Util.MyUtil;
import model.Model;
import model.domain.Customer;
import view.EndView;

public class Controller {
	
	private Model database = new Model();
	private EndView eV = new EndView();
	
	public void showAllCustomer() {
		ArrayList<Customer> al = database.getAllCustomer();
		
		for(Customer c : al) {
			eV.showPrinter(c.getRecord());
		}
		eV.showPrinter("---");
	}
	
	public void showCustomer(Object cName) {
		eV.showPrinter(database.getCustomer(cName).getRecord());
		eV.showPrinter("---");
	}
	
	public void login(String cName) {
		
		Customer c = database.getCustomer(cName);
		
		if(c == null) {
			eV.showPrinter("로그인 실패.");
			return;
		}
		
		eV.showPrinter(MyUtil.strMapping(c.getCname()) + "님이 로그인 하셨습니다.");
		eV.showPrinter(" - 잔액은 " + 
				c.getCmoney()+"원 이며, 등급은 " + 
				MyUtil.strMapping(database.getMembership(c.getMno()).getMname()) + " 입니다.");
	}
	
	public void signin(String cname, Integer cmoney) {
		ArrayList<Customer> al = database.getAllCustomer();
		this.signin(al.get(al.size() - 1).getCno() + 1, cname, cmoney);
		
	}
	
	public void signin(int cno, String cname, Integer cmoney) {
		
		if(database.getCustomer((Integer)cno) != null) {
			eV.showPrinter("이미 등록된 회원입니다.");
			return;
		}
		
		Integer mno = null;
		
		if(cmoney == null) {
			mno = null;
		} else if(cmoney < 500) {
			// silver
			mno = 10;
		} else if (cmoney >= 500){
			// gold
			mno = 20;
		}
		
		boolean isSuccess =  database.insertCustomer(cno, cname, cmoney, mno);
		
		if(isSuccess) {
			eV.showPrinter(cname + "님이 회원가입에 성공하셨습니다.");
		}else {
			eV.showPrinter("회원가입이 거부되었습니다.");
		}
	}
	
}
