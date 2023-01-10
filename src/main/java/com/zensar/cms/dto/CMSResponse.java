package com.zensar.cms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @author Grishma Kagde
 *
 * Course Management System CMSResponse dto class.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CMSResponse {

	private Integer status;
	private String error;
	private String message;

	public CMSResponse() 
	{
		
	}
	
	public CMSResponse(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public CMSResponse(String error, String message) {
		super();
		this.error = error;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
