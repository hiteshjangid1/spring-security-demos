# In-Memory UserDetails

1.  Open the last project

2.  Open `SecurityConfig.java` and add new method

    ```java
    @Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user1 =
			 User.withDefaultPasswordEncoder()
				.username("mahendra")
				.password("pass@1234")
				.roles("USER")
				.build();
		UserDetails user2 = User.withDefaultPasswordEncoder()
				.username("narendra")
				.password("pass@123456")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(Arrays.asList(user1, user2));
	}
    ```

3.  Open `HomeController.java` and replace the old code with this new:

    ```java
    
    @Controller
    @RequestMapping("/")
    public class HomeController {

        @PreAuthorize("permitAll")
        @GetMapping
        public String home() {
            return "home";
        }
        
        @PreAuthorize("hasRole('ROLE_USER')")
        @GetMapping("/contactus")
        public String contactus() {
            return "contactus";
        }
    }
    ```

4.  Open `src/main/resources/application.properties` either COMMENT or DELETE following lines

    ```ini
    #spring.security.user.name=mahendra
    #spring.security.user.password=pass@12345
    ```

5.  Run Application and VISIT url http://localhost:8080/contactus

    5.1 Login with mahendra/pass@12345 would allow access to page
    5.2 Login with narendra/pass@123456 would DENY access to page