## Role based Access Control

1.  Edit security-context.xml file to add new user with ROLE `admin`

    ```xml
    <security:http auto-config="true" >
		
		<security:headers>
		<!-- Disable browser back button to load page from CACHE  -->
			<security:cache-control />
		</security:headers>
		
	    <security:intercept-url pattern="/" access="IS_AUTHENTICATED_ANONYMOUSLY"/>
	    <security:intercept-url pattern="/resources/**" access="IS_AUTHENTICATED_ANONYMOUSLY"/>
		<security:intercept-url pattern="/loans" access="ROLE_USER"  />
		<security:intercept-url pattern="/admin" access="ROLE_ADMIN"  />
		<security:logout invalidate-session="true"  logout-url="/logout" />
		<security:form-login  />
		
	</security:http>    
	
	<security:authentication-manager>
		<security:authentication-provider>
			<security:user-service>
				<security:user name="mahendra" authorities="ROLE_USER" password="password@1234"/>
				<security:user name="admin" authorities="ROLE_ADMIN" password="admin@1234"/>
			</security:user-service>
		</security:authentication-provider>
	</security:authentication-manager>
    ```

2.  Create a new controller class `AdminController` in package `com.mahendra.controllers`

    ```java
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;

    @Controller
    @RequestMapping("/admin")
    public class AdminController {

        @RequestMapping(method = RequestMethod.GET)
        public String adminConsole() {
            return "admin";
        }
    }
    ```

3.  Create a JSP page `src/main/webapp/WEB-INF/view/admin.jsp`

    ```xml
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>

    <html>
    <head>
    <meta charset="ISO-8859-1">
    <c:url value="/resources/main.css" var="cssRef"/>
    <link type="text/css" href="${cssRef}" rel="stylesheet"/>
    <title>Administrator Console</title>
    </head>
    <body>
    <h2>Administrators Console</h2>
    <p>
    The admin console to manage all the internal tasks.
    </p>
    </body>
    </html>
    ```

4.  Modify home page `hello.jsp` to include one more HYPERLINK 

    ```
    <a href="admin">Admin Console</a>
    ```