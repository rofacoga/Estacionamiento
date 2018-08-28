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
	public Iterable<KeeperDto> getAllKeepers();

	/**
	 * 
	 * @param keeper
	 * @return
	 */
	public KeeperDto saveKeeper(KeeperDto keeper);

	/**
	 * 
	 * @param keeper
	 * @return
	 */
	public KeeperDto deleteKeeper(KeeperDto keeper);

	/**
	 * 
	 * @param idType
	 * @return
	 */
	public KeeperDto searchById(Long idType);

	/**
	 * 
	 * @param user
	 * @param pass
	 * @return
	 * @throws AnExceptionHandler 
	 */
	public KeeperDto login(String user, String pass) throws AnExceptionHandler;
}
