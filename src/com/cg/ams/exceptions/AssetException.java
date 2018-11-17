package com.cg.ams.exceptions;

public class AssetException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public AssetException(String message) {
		super();
		this.message = message;
	}
	

}
