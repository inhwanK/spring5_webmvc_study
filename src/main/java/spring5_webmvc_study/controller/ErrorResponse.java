package spring5_webmvc_study.controller;

public class ErrorResponse {
	private String message;
	
	public ErrorResponse(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
