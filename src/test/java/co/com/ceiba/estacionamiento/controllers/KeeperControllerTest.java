package co.com.ceiba.estacionamiento.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.estacionamiento.service.dtos.KeeperDto;
import co.com.ceiba.estacionamiento.service.dtos.ParkingRecordDto;
import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.services.KeeperServiceInterface;
import co.com.ceiba.estacionamiento.service.services.ParkingRecordServiceInterface;
import co.com.ceiba.estacionamiento.utilities.VehicleTypeEnum;

/**
 * 
 * @author roger.cordoba
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(KeeperController.class)
public class KeeperControllerTest {
	@MockBean
	private KeeperServiceInterface keeperService;
	@MockBean
	private ParkingRecordServiceInterface recordService;
	@Autowired
	private MockMvc mock;
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void testLoginOk() throws Exception {
		KeeperDto keeper = new KeeperDto();

		keeper.setUsername("jd");
		keeper.setPassword("12345ceiba");

		String keeperData = mapper.writeValueAsString(keeper);
		this.mock.perform(
				post("/keeper/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(keeperData)
				).andExpect(status().isOk());
	}
	
	@Test
	public void testCheckIn() throws Exception {
		VehicleDto vehicle = new VehicleDto();
		vehicle.setType(VehicleTypeEnum.MOTORCYCLE);
		vehicle.setCylinder(600);
		vehicle.setPlate("abc123");
		ParkingRecordDto record = new ParkingRecordDto();
		record.setVehicle(vehicle);
		record.setCheckIn(Calendar.getInstance());
		record.setKeeperIn(Long.valueOf(1));

		String recordData01 = mapper.writeValueAsString(record);

		this.mock.perform(
				post("/keeper/checkIn")
				.contentType(MediaType.APPLICATION_JSON)
				.content(recordData01)
				).andExpect(status().isOk());
	}
	
	@Test
	public void testCheckOut() throws Exception {
		VehicleDto vehicle = new VehicleDto();
		vehicle.setType(VehicleTypeEnum.MOTORCYCLE);
		vehicle.setCylinder(600);
		ParkingRecordDto record = new ParkingRecordDto();
		record.setVehicle(vehicle);
		record.setCheckIn(Calendar.getInstance());
		record.setKeeperIn(Long.valueOf(1));

		String recordData01 = mapper.writeValueAsString(record);

		this.mock.perform(
				post("/keeper/checkOut")
				.contentType(MediaType.APPLICATION_JSON)
				.content(recordData01)
				).andExpect(status().isOk());
	}
	
	@Test
	public void testAllParkedVehicles() throws Exception {
		this.mock.perform(
				get("/keeper/allParkedVehicles")
				).andExpect(status().isOk());
	}
	
	@Test
	public void testParkedVehiclesHistory() throws Exception {
		this.mock.perform(
				post("/keeper/parkedVehiclesHistory")
				).andExpect(status().isOk());
	}
	
	@Test
	public void testSaveKeeper() throws Exception {
		KeeperDto keeper = new KeeperDto();
		keeper.setDni("1234567890");
		keeper.setEmail("example@domain.co");
		keeper.setFirstName("Juan");
		keeper.setLastName("Duran");
		keeper.setMobileNumber("3216547890");
		keeper.setUsername("juda");
		keeper.setPassword("juda1234");

		String recordData01 = mapper.writeValueAsString(keeper);

		this.mock.perform(
				post("/keeper/saveKeeper")
				.contentType(MediaType.APPLICATION_JSON)
				.content(recordData01)
				).andExpect(status().isOk());
	}
}
