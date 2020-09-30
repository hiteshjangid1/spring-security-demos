## Spring Web demo

## Pre-requisites

1.  JDK 8 
2.  Spring ToolSuite or eclipse JEE Developer
3.  Apache Tomcat 9


### Steps

1.  Launch SpringTool or eclipse open the workspace eg. "C:\workspace1"

2.  File -> New -> Maven Project > Simple Project (Skip Archetype Selection)

    Click NEXT then provide details

    ```yml
    GroupId: com.mahendra
    ArtifactId: MyApp3
    Versions: 1.0
    Packaging: War
    Project: MyApp3
    ```

3.  Add following extra lines in `pom.xml` file

    ```xml
    <dependencies>
    <dependency>
        <groupId>javax.servlet.jsp.jstl</groupId>
        <artifactId>javax.servlet.jsp.jstl-api</artifactId>
        <version>1.2.2</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>3.2.15.RELEASE</version>
        </dependency>
    </dependencies>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
    ```

4.  Right click on project name (In project explorer) and choose option "Java EE Tools" > Generate Deployment Descriptor Stub

5.  It should create `web.xml` file and also remove ERROR from pom.xml

6.  Inside `web.xml` file add following code-snippet

    ```xml
     <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>CLASSPATH:/spring/servlet-context.xml</param-value>
        </init-param>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    ```

7.  Inside `src/main/resources` create a folder `spring` and then create a file `src/main/resources/spring/servlet-context.xml`

    ```xml
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    
    <!-- Search for Spring components in package 'com.mahendra' and it's sub-packages like com.mahedra.controllers -->
    <context:component-scan base-package="com.mahendra"/>
        
        <bean id="viewResolver"
            class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/WEB-INF/views/"/>
            <property name="suffix" value=".jsp"/>	
        </bean>
        
    </beans>
    ```

8.  Create a Controller class inside folder: `src/main/java` with package name `com.mahendra.controllers`

    ```java
    package com.mahendra.controllers;

    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;


    @Controller
    @RequestMapping("/")
    //## Real URL: http://localhost:8080/MyApp3/
    public class HomeController {

        @RequestMapping(method = RequestMethod.GET)
        public String sayHello() {
            //Using ViewResolver defined in servlet-context.xml file at line#18
            //"hello" becomes "/WEB-INF/views/hello.jsp"
            return "hello";
        }
        
    }
    ```

9.  Create a JSP file in folder `src/main/webapps/WEB-INF/views/hello.jsp`

    ```jsp
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
    </body>
    </html>
    ```

10. Right click on project name (inside project-explorer) and Run As > Run On Server
