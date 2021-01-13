package jpabook.jpashop;

import jpabook.jpashop.domain.Hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.origin.SystemEnvironmentOrigin;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {

		Hello hello = Hello.builder()
				.name("ose")
				.age(11)
				.build();
		hello.getName();

		SpringApplication.run(JpashopApplication.class, args);
	}

}
