package co.com.ceiba.estacionamiento.service.services.impl;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.persistence.entities.Keeper;
import co.com.ceiba.estacionamiento.persistence.repositories.KeeperRepository;
import co.com.ceiba.estacionamiento.service.dtos.KeeperDto;
import co.com.ceiba.estacionamiento.service.services.KeeperServiceInterface;

/**
 * 
 * @author roger.cordoba
 */
@Service
public class KeeperService implements KeeperServiceInterface {

	@Autowired
	private KeeperRepository repository;

	@Override
	public Iterable<KeeperDto> getAllKeepers() {
		return new KeeperDto().listEntitiesToDtos(this.repository.findByRegistrationActive(true));
	}

	@Override
	public KeeperDto searchById(Long idKeeper) {
		if (idKeeper == null) {
			return new KeeperDto();
		}

		Optional<Keeper> keeper = this.repository.findById(idKeeper);
		if (keeper.isPresent()) {
			return new KeeperDto().entityToDto(keeper.get());
		}
		return new KeeperDto();
	}

	@Override
	public KeeperDto saveKeeper(KeeperDto keeper) {
		if (keeper == null) {
			return new KeeperDto();
		}

		if (keeper.getId() == null) {
			keeper.setRegistrationActive(true);
			keeper.setRegistrationDate(Calendar.getInstance());
		}

		Keeper entity = this.repository.save(keeper.dtoToEntity());

		return keeper.entityToDto(entity);
	}

	@Override
	public KeeperDto deleteKeeper(KeeperDto keeper) {
		keeper.setRegistrationActive(false);

		Keeper entity = this.repository.save(keeper.dtoToEntity());

		return keeper.entityToDto(entity);
	}

	@Override
	public KeeperDto login(String user, String pass) {
		if (user==null
				||pass==null) {
			return new KeeperDto();
		}

		Long idKeeper = this.repository.findIdByUserAndPass(user, pass);
		if (idKeeper==null) {
			return new KeeperDto();
		}

		return this.searchById(idKeeper);
	}
}
