package game.app.exceptions.handler;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import game.app.dtos.GameErrorDto;
import game.app.dtos.GenreErrorDto;
import game.app.exceptions.generic.GameKOException;
import game.app.exceptions.generic.NoContentException;
import game.app.exceptions.generic.NotFoundException;

@ControllerAdvice
public class GenreHandlerException extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({GameKOException.class})
	@ResponseBody
	public GenreErrorDto gameKO(HttpServletRequest request, GameKOException exception) {
		return new GenreErrorDto("00", exception.getDetalle());
	}
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({NotFoundException.class})
	@ResponseBody
	public GenreErrorDto notFoundRequest(HttpServletRequest request, NotFoundException exception) {
		return new GenreErrorDto("01", exception.getDetalle());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler({NoContentException.class})
	@ResponseBody
	public GenreErrorDto notContentRequest(HttpServletRequest request, NoContentException exception) {
		return new GenreErrorDto("01", exception.getDetalle());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream().map( e -> e.getDefaultMessage()).collect(Collectors.toList());
		return new ResponseEntity<>(new GenreErrorDto("02", errorMessages.toString()),
				HttpStatus.BAD_REQUEST);
	}
}
