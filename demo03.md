## Basic Security

1.  Open the project created by following demo01 & demo02

2.  Open `pom.xml` file and add few dependencies

    ```xml
    <!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-core -->
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-core</artifactId>
        <version>3.2.10.RELEASE</version>
    </dependency>

    
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-web</artifactId>
        <version>3.2.10.RELEASE</version>
    </dependency>

    
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-config</artifactId>
        <version>3.2.10.RELEASE</version>
    </dependency>

    <dependency>
			<groupId>commons-logging</groupId>
			<artifactId>commons-logging</artifactId>
			<version>1.2</version>
	</dependency>
    ```

3.  Modify `web.xml` for security configuration.

    ```xml
    	<filter>
		<filter-name>springSecurityFilterChain</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
		
	</filter>

	<filter-mapping>
		<filter-name>springSecurityFilterChain</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	
	<context-param>
		<description>Spring Security XML Configuration</description>
		<param-name>contextConfigLocation</param-name>
		<param-value>CLASSPATH:/spring/security-context.xml</param-value>
	</context-param>
	
	<servlet>
		<servlet-name>dispatcher</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>CLASSPATH:/spring/servlet-context.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
		
	</servlet>

	<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
    ```

4.  Create a new XML file `src/main/resources/spring/security-context.xml`

    ```xml
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:security="http://www.springframework.org/schema/security"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
            http://www.springframework.org/schema/security
            http://www.springframework.org/schema/security/spring-security-3.2.xsd">
	
        
        <security:http auto-config="true">
            <security:intercept-url pattern="/**" access="ROLE_USER" />
            <security:http-basic />
        </security:http>    
        
        <security:authentication-manager>
            <security:authentication-provider>
                <security:user-service>
                    <security:user name="mahendra" authorities="ROLE_USER" password="password@1234"/>
                </security:user-service>
            </security:authentication-provider>
        </security:authentication-manager>
    </beans>
    ```

5.  Right click on project > Run on server 
    You should get a Dialogbox for User credentials

    Username:   mahendra
    Password:   password@1234


> The completed code can be found at [project](./MyApp4)