package com.mahendra.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mahendra.models.Loan;

@Controller
@RequestMapping("/loans")
public class LoanController {

	@RequestMapping(method = RequestMethod.GET)
	public String listLoans(Model map) {
		LinkedList<Loan> loans = new LinkedList<>();
		loans.add(new Loan(10001, "Neerav", convertToDate("03-14-1990") , 12000, 14.5));
		loans.add(new Loan(10002, "Rajeev", convertToDate("03-10-1998") , 15000, 15.5));
		loans.add(new Loan(10003, "Vijay", convertToDate("07-20-1999") , 20000, 13.1));
		
		map.addAttribute("loans",loans);
		return "list-loans";
	}
	
	
	private Date convertToDate(String date) {
		SimpleDateFormat df = new SimpleDateFormat("mm-dd-yyyy");
		try {
			return df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
