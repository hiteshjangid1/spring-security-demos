# Exclude STATIC Resources from Dispatcher Servlet & Authentication filters

1.  Create a folder for static resources `src/main/webapp/resources/`

2.  Create a CSS file `main.css` inside resources

    ```css
    @charset "ISO-8859-1";
    body{
        background-color: lightblue;
        margin: 0px;
        padding: 5px;
    }
    h1, h2, h3, h4 {
        color: brown;
    }
    ```

3.  Inject this CSS into both JSP pages `hello.jsp` and `list-loans.jsp`

    3.1 src/main/webapp/WEB-INF/views/hello.jsp

    ```xml
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- TAG LIB for CORE UTILITIES -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1">

    <!-- c:url would translate /resources/main.css into /MyApp3/resources/main.css 
        It would DYNAMICALLY prefix the APPNAME to URL
    -->
    <c:url value="/resources/main.css" var="cssRef"/>

    <link type="text/css" rel="stylesheet" href="${cssRef}"/>

    <title>Home Page</title>
    </head>
    <body>
    <h2>Hello World!</h2>
    <a href="loans">Out-standing Loans</a>
    </body>
    </html>
    ```

    3.2 src/main/webapp/WEB-INF/views/list-loans.jsp

    ```xml
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <html>
    <head>
    <meta charset="ISO-8859-1">
    <title>List of Outstanding Loans</title>
    <c:url value="/resources/main.css" var="cssRef"/>
    <link type="text/css" rel="stylesheet" href="${cssRef}"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Cache-Control" content="no-store" />
    </head>
    <body>
    <form action="logout" method="post"><input type="submit" value="logout"/></form>
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

4.  Exclude RESOURCES from dispatcher servlet, open `servlet-context.xml` and add these lines:

    ```xml
    <mvc:annotation-driven />

	<!-- All request which contains pattern "/resources/**" should be redirected to "resources" folder under webapp -->
	<mvc:resources location="/resources/" 
		mapping="/resources/**" />
    ```

5.  Exclude RESOURCES from authentication filter. open `security-context.xml` and add these lines:

    ```xml
	<security:http auto-config="true" >
	    <security:intercept-url pattern="/" access="IS_AUTHENTICATED_ANONYMOUSLY"/>
        <!-- EXCLUDE RESOURCES -->
	    <security:intercept-url pattern="/resources/**" access="IS_AUTHENTICATED_ANONYMOUSLY"/>
        
		<security:intercept-url pattern="/loans" access="ROLE_USER"  />
		<security:logout invalidate-session="true"  logout-url="/logout" />
		<security:form-login  />		
	</security:http> 
    ```