
package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@SpringBootApplication
@ComponentScan(basePackages="controller,repository,service") 
@EnableMongoRepositories(basePackages="repository")

public class Application  {
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	

}