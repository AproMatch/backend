package cocone.wero.apro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AproApplication {

	public static void main(String[] args) {
		SpringApplication.run(AproApplication.class, args);
	}

}
