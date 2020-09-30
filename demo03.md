## Basic Security

1.  Open the project created by following demo01 & demo02

2.  Open `pom.xml` file and add few dependencies

    ```xml
    <!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-core -->
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-core</artifactId>
        <version>3.0.0.RELEASE</version>
    </dependency>

    
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-web</artifactId>
        <version>3.0.RELEASE</version>
    </dependency>

    
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-config</artifactId>
        <version>3.0.0.RELEASE</version>
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
    <context-param>
		<description>Spring Security XML Configuration</description>
		<param-name>contextConfigLocation</param-name>
		<param-value>CLASSPATH:/spring/security-context.xml</param-value>
	</context-param>
    ```

4.  Create a new XML file `src/main/resources/spring/security-context.xml`

    ```xml
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:security="http://www.springframework.org/schema/security"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
            http://www.springframework.org/schema/security
            http://www.springframework.org/schema/security/spring-security-3.0.3.xsd">
        
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

