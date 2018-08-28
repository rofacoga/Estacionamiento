package co.com.ceiba.estacionamiento.controllers.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.ceiba.estacionamiento.utilities.exceptions.DateCheckInIsAfterThanDateCheckOutException;
import co.com.ceiba.estacionamiento.utilities.exceptions.DayToEvaluateInvalidException;
import co.com.ceiba.estacionamiento.utilities.exceptions.IncorrectDataLoginException;
import co.com.ceiba.estacionamiento.utilities.exceptions.ParkingExceedsTheAllowedCapacityException;
import co.com.ceiba.estacionamiento.utilities.exceptions.RegistrationOfParkedVehicleNotFoundException;
import co.com.ceiba.estacionamiento.utilities.exceptions.ThePlateIsAlreadyRegisteredException;
import co.com.ceiba.estacionamiento.utilities.exceptions.ThePlateStartWithTheLetterException;

/**
 * 
 * @author roger.cordoba
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler({ 
		DateCheckInIsAfterThanDateCheckOutException.class,
		DayToEvaluateInvalidException.class,
		IncorrectDataLoginException.class,
		ParkingExceedsTheAllowedCapacityException.class,
		RegistrationOfParkedVehicleNotFoundException.class,
		ThePlateIsAlreadyRegisteredException.class,
		ThePlateStartWithTheLetterException.class
	})
	@ResponseBody
	protected ResponseEntity<Object> handleOfConflict(Exception ex) {
		ApiError apiError = new ApiError(HttpStatus.CONFLICT);
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
}
