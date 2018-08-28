package co.com.ceiba.estacionamiento;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author roger.cordoba
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("co.com.ceiba.estacionamiento.persistence.repositories")
@EntityScan("co.com.ceiba.estacionamiento.persistence.entities")
public class AppConfig {

}
