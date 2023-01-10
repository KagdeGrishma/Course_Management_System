package com.zensar.cms.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
/*	
	public ResponseEntity<Object> handleStockIdError(RuntimeException exception,WebRequest request){
		
		@ExceptionHandler=(value= {InvalidStockIdException.class})
				public ResponseEntity<Object> handleStockIdError(RuntimeException exception, WebRequest request){
			return handleExceptionInternal(exception, exception.toString(), new HttpHEaders, HttpStatus.BAD_REQUEST, request);
		}
	}

}*/
}
