package com.hrs.hotel.booking.utils;

/**
 * 
 * @param <T> here T is the type of response object
 */
public class HttpResponse<T> {
	private String requestId;
	private String status;
	private T responseObject;
	
	public HttpResponse() {
	
	}
	
	public HttpResponse(String requestId, String status, T responseObject) {
		super();
		this.requestId = requestId;
		this.status = status;
		this.responseObject = responseObject;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getResponseObject() {
		return responseObject;
	}
}