package com.in28minutes.rest.webservices.restwebservices.expection;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	 public final ResponseEntity<Object> handleExceptionInternalServer(Exception ex, WebRequest request) throws Exception {
			
	   ExceptionDetails exceptiodetail = new ExceptionDetails(ex.getMessage(), new Date(),request.getDescription(false));
			
		return new ResponseEntity(exceptiodetail,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
  @ExceptionHandler(UserDefineException.class)
   public final ResponseEntity<Object> handleExceptionNotFound(Exception ex, WebRequest request) throws Exception {
		
		ExceptionDetails exceptiodetail = new ExceptionDetails(ex.getMessage(), new Date(),request.getDescription(false));
		
		return new ResponseEntity(exceptiodetail,HttpStatus.NOT_FOUND);
	}
  
  @ExceptionHandler(BadRequest.class)
  public final ResponseEntity<Object> handleExceptionBadRequest(Exception ex, WebRequest request) throws Exception {
		
		ExceptionDetails exceptiodetail = new ExceptionDetails(ex.getMessage(), new Date(),request.getDescription(false));
		
		return new ResponseEntity(exceptiodetail,HttpStatus.BAD_REQUEST);
	}
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

	  ExceptionDetails exceptiodetail = new ExceptionDetails("Invalid Arguments", new Date(),ex.getBindingResult().toString());
		
		return new ResponseEntity(exceptiodetail,HttpStatus.BAD_REQUEST);
	}
}
