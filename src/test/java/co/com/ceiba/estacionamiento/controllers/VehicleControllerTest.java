package co.com.ceiba.estacionamiento.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.services.VehicleServiceInterface;
import co.com.ceiba.estacionamiento.utilities.VehicleTypeEnum;

/**
 * 
 * @author roger.cordoba
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {
	@MockBean
	private VehicleServiceInterface vehicleService;
	@Autowired
	private MockMvc mock;
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void testAllVehicles() throws Exception {
		this.mock.perform(
				get("/vehicle/allVehicles")
				).andExpect(status().isOk());
	}
	
	@Test
	public void testAllTypesVehicles() throws Exception {
		this.mock.perform(
				get("/vehicle/allTypesVehicles")
				).andExpect(status().isOk());
	}
	
	@Test
	public void testSaveVehicle() throws Exception {
		VehicleDto vehicle = new VehicleDto();
		vehicle.setPlate("abc123");
		vehicle.setType(VehicleTypeEnum.MOTORCYCLE);
		vehicle.setCylinder(600);

		String recordData = mapper.writeValueAsString(vehicle);

		this.mock.perform(
				post("/vehicle/saveVehicle")
				.contentType(MediaType.APPLICATION_JSON)
				.content(recordData)
				).andExpect(status().isOk());
	}
}
