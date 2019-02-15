package com.zivame.zivame.exception;

public class Exceptoin_VO {

	private String errorMessage;
	private String requestURI;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	public void callerURL(String requestURI2) {
		this.requestURI = requestURI;
		
	}

}
