package com.mahendra.models;

import java.util.Date;

public class Loan {
	private Integer loanId;
	private String customerName;
	private Date dateOfDisbursement;
	private double emi;
	private double rateOfInterest;
	
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getDateOfDisbursement() {
		return dateOfDisbursement;
	}
	public void setDateOfDisbursement(Date dateOfDisbursement) {
		this.dateOfDisbursement = dateOfDisbursement;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	
	
	public Loan(Integer loanId, String customerName, Date dateOfDisbursement, double emi, double rateOfInterest) {
		super();
		this.loanId = loanId;
		this.customerName = customerName;
		this.dateOfDisbursement = dateOfDisbursement;
		this.emi = emi;
		this.rateOfInterest = rateOfInterest;
	}
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
