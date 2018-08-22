package co.com.ceiba.estacionamiento.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.estacionamiento.persistence.entities.Keeper;

/**
 * 
 * @author roger.cordoba
 */
public interface KeeperRepository extends CrudRepository<Keeper, Long> {
	/**
	 * 
	 * @param regState
	 * @return
	 */
	public List<Keeper> findByRegistrationActive(Boolean isActive);
}
