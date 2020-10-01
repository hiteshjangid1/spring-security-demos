# Spring Security with Spring Boot

Pre-Requisite
1. Java 8 Onwards
2. SpringTool Suite 4.x

1. Create New `Spring Starter project`

    ```yml
    Type: Maven
    Name: demo-8
    Java-Version: 8
    Language: Java
    Packaging: War
    Group: com.mahendra
    ArtifactId: demo-8
    Version: 1.0
    Description: Security Demo
    Base-Package: com.mahendra.demo8
    ```

2.  Click NEXT to choose Dependencies and Spring boot version

    ```yml
    Spring-Boot: 2.2.10
    Dependencies: Web, Security, Thymeleaf
    ```

3.  Click 'next' and then 'finish'

4.  Add new Class under package `com.mahendra.demo8.controllers'

    > Incorrect packagename would result in 404 errors

    > Controller must be INSIDE base-package

5.  The Code for `HomeController`

    ```java
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/")
    public class HomeController {

        @GetMapping
        public String home() {
            return "home";
        }
    }
    ```

6.  Create a HTML file inside `src/main/resources/templates` with name `home.html`

    ```
    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org">
    <head>
    <meta charset="ISO-8859-1">
    <title>Home page</title>
    </head>
    <body>
    <h1>Hello World</h1>
    <a href="contactus">Contact Us</a>
    </body>
    </html>
    ```

7.  Edit `src/main/resources/application.properties`

    ```ini
    server.port=8080
    spring.security.user.name=mahendra
    spring.security.user.password=pass@12345
    ```

8.  Open Java class `src/main/java/com/mahendra/demo8/Demo8Application`

    Right click > Run As > Run As Java Application

9.  Open your web browser to access http://localhost:8080

10. Create new Java Class `SecurityConfig` in base-package `com.mahendra.demo8`

    ```java
    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/**").authorizeRequests().antMatchers("/").permitAll()
            .anyRequest().authenticated().and().formLogin();
        }
        
    }
    ```

11. Open the HomeController class and replace the old code with new one:

    ```java
    @Controller
    @RequestMapping("/")
    public class HomeController {

        @PreAuthorize("permitAll")
        @GetMapping
        public String home() {
            return "home";
        }
        
        //Must Authenticate Yourself 
        @GetMapping("/contactus")
        public String contactus() {
            return "contactus";
        }
    }
    ```
12. Create `contactus.html` in `src/main/resources/templates/`

    ```html
    <!DOCTYPE html>
    <html xmlns="https://www.thymeleaf.org">
    <head>
    <meta charset="ISO-8859-1">
    <title>Contact Us</title>
    </head>
    <body>
    <h2>Contact Information</h2>
    </body>
    </html>
    ```

13. Stop the running instances (If any) from "console" panel

14. Right click on Demo8Application.java > Run As > Java Application

15. Open web-browser and visit `http://localhost:8080`