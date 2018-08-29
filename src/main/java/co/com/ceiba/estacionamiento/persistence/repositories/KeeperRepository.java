package co.com.ceiba.estacionamiento.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.estacionamiento.persistence.entities.Keeper;

/**
 * 
 * @author roger.cordoba
 */
public interface KeeperRepository extends CrudRepository<Keeper, Long> {
	/**
	 * Method that allows listing all active objects
	 * 
	 * @param isActive
	 * @return the list of objects
	 */
	public List<Keeper> findByRegistrationActive(Boolean isActive);

	@Query("select k.id "
			+ "from Keeper k "
			+ "where (k.mobileNumber=:user or k.email=:user or k.username=:user) "
			+ "and k.p4ssw0rd=:pass")
	public Long findIdByUserAndPass(@Param("user") String user, @Param("pass") String pass);
}
