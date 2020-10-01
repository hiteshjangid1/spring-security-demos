## Implements LOGOUT functionality

1.  Open security-context.xml file and update the "http" component

    ```xml
    <security:http auto-config="true" >
	    <security:intercept-url pattern="/" access="IS_AUTHENTICATED_ANONYMOUSLY"/>
		<security:intercept-url pattern="/loans" access="ROLE_USER"  />
		<security:logout invalidate-session="true"  logout-url="/logout" />
		<security:form-login  />

	</security:http>    
    ```

2.  Open JSP page `src/webapp/WEB-INF/views/list-loans.jsp`
    Add the FORM tag somewhere inside BODY element.

    ```html
    <form action="logout" method="post">
        <input type="submit" value="logout"/>
    </form>
    ```
