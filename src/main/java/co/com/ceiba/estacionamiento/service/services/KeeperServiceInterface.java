package co.com.ceiba.estacionamiento.service.services;

import co.com.ceiba.estacionamiento.service.dtos.KeeperDto;
import co.com.ceiba.estacionamiento.utilities.exceptions.AnExceptionHandler;

/**
 * 
 * @author roger.cordoba
 */
public interface KeeperServiceInterface {
	/**
	 * Method that allows listing all active Keepers
	 * 
	 * @return the list of Keepers
	 */
	Iterable<KeeperDto> getAllKeepers();

	/**
	 * 
	 * @param keeper
	 * @return
	 */
	KeeperDto saveKeeper(KeeperDto keeper);

	/**
	 * 
	 * @param keeper
	 * @return
	 */
	KeeperDto deleteKeeper(KeeperDto keeper);

	/**
	 * 
	 * @param idType
	 * @return
	 */
	KeeperDto searchById(Long idType);

	/**
	 * 
	 * @param user
	 * @param pass
	 * @return
	 * @throws AnExceptionHandler 
	 */
	KeeperDto login(String user, String pass) throws AnExceptionHandler;

	/**
	 * 
	 * @param id
	 * @return
	 */
	KeeperDto deleteKeeperById(Long id);
}
