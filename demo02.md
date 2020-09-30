## Demo 2: Multiple controllers

1. Open the project created by demo01

2.  Create a new java class `Loan` in package `com.mahendra.models`

    ```java
    package com.mahendra.models;

    import java.util.Date;

    public class Loan {
        private Integer loanId;
        private String customerName;
        private Date dateOfDisbursement;
        private double emi;
        private double rateOfInterest;
    }
    ```

3.  Use `Source > Generate Getters & Setters` to generate getter & setter methods in `Loan` class.

4.  Use `Source > Generate Constructor from Superclass` for constructor without arguments.

5.  Use `Source > Generate Constructor Using fields` for parameterized constructor.

6.  Create class `LoanController` in package `com.mahendra.controllers`

    ```java
    package com.mahendra.controllers;

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

    ```

7.  Create a JSP page `src/main/webapp/WEB-INF/views/list-loans.jsp`

    ```xml
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>
    <head>
    <meta charset="ISO-8859-1">
    <title>List of Outstanding Loans</title>
    </head>
    <body>

    <h2>List of Out-standings</h2>
    <table border="1" >
    <thead>
    <tr>
    <td>Loan Account </td>
    <td>Customer Name</td>
    <td>EMI</td>
    <td>Rate of Interest</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${loans}" var="x">
    <tr>
        <td>${x.loanId}</td>
        <td> ${x.customerName }</td>
        <td> ${x.emi }</td>
        <td>${x.rateOfInterest }</td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
    </body>
    </html>
    ```

8.  Modify the `src/main/webapp/WEB-INF/views/hello.jsp`

    ```xml
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
    </head>
    <body>
    <h2>Hello World!</h2>
    <a href="loans">Out-standing Loans</a>
    </body>
    </html>
    ```