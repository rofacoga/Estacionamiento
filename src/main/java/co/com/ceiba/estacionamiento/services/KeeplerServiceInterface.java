package co.com.ceiba.estacionamiento.services;

import co.com.ceiba.estacionamiento.persistence.entities.Keeper;

/**
 * 
 * @author roger.cordoba
 */
public interface KeeplerServiceInterface {
	/**
	 * 
	 * @return
	 */
	public Iterable<Keeper> getAllKeepers();

	/**
	 * 
	 * @param keeper
	 * @return
	 */
	public Keeper saveKeeper(Keeper keeper);

	/**
	 * 
	 * @param keeper
	 * @return
	 */
	public Keeper deleteKeeper(Keeper keeper);
}
