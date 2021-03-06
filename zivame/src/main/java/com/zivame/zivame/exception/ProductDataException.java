package com.zivame.zivame.exception;

import javax.servlet.http.HttpServletRequest;

import com.zivame.zivame.controller.ProductController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ProductDataException {

	private static final Logger logger = LogManager.getLogger(ProductDataException.class);
	
	
	@ExceptionHandler(ProductException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody Exceptoin_VO handleResourceNotFound(final ProductException exception,
			final HttpServletRequest request) {

		Exceptoin_VO error = new Exceptoin_VO();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		logger.info(exception.getMessage());

		return error;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody Exceptoin_VO handleException(final Exception exception,
			final HttpServletRequest request) {

		Exceptoin_VO error = new Exceptoin_VO();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		logger.info(exception.getMessage());
		return error;
	}


}
