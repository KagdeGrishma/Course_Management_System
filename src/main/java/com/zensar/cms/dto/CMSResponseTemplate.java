package com.zensar.cms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * @author Grishma Kagde
 *
 * Course Management System CMSResponseTemplate dto class.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CMSResponseTemplate<T> extends CMSResponse {

	private T data;
	
	public CMSResponseTemplate() {
		super();
	}
	
	public CMSResponseTemplate(T data, Integer status, String message) {
		super(status,message);
		this.data = data;
	}
	
	public CMSResponseTemplate(Integer status, String message) {
		super(status,message);
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
