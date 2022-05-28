package be.fednot.testguillermo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
//		(exclude = {DataSourceAutoConfiguration.class})
public class TestguillermoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestguillermoApplication.class, args);
	}

}
