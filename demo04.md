# Role based access for loan URL pattern and Anonymous authentication for home page.

1. Open Security-context.xml file

    replace the OLD "http" component with this one:

    ```xml
    <security:http auto-config="true" >
	    <security:intercept-url pattern="/" access="IS_AUTHENTICATED_ANONYMOUSLY"/>
		<security:intercept-url pattern="/loans" access="ROLE_USER"  />
		<security:form-login  />
	</security:http>  
    ```

2.  Stop the TOMCAT server, remove application from tomcat and run on server once again.

3.  Visit `http://localhost:8080/MyApp3/` No User credentials required.

4.  Visit `http://localhost:8080/MyApp3/loans` Authentication is required.

