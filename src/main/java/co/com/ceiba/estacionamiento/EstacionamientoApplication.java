package co.com.ceiba.estacionamiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author roger.cordoba
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("co.com.ceiba.estacionamiento.persistence.repositories")
@EntityScan("co.com.ceiba.estacionamiento.persistence.entities")
public class EstacionamientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamientoApplication.class, args);
	}
}
