package nulledge.study_spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfiguration  {

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();
		return passwordEncoder;
	}
	
}
