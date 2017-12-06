package com.example.demo.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ResponseDTO implements Serializable {

	private static final long serialVersionUID = -6332314983916233701L;
	
	private HttpStatus status;
	private Object data;
	private Map<String, Object> aggregatedObjects;
	
	public ResponseDTO(HttpStatus status, Object data){
		super();
		this.status = status;
		this.data = data;
	}
	
	public ResponseDTO(HttpStatus status, Map<String, Object> aggregatedObjects){
		super();
		this.status = status;
		this.aggregatedObjects = aggregatedObjects;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Map<String, Object> getAggregatedObjects() {
		return aggregatedObjects;
	}

	public void setAggregatedObjects(Map<String, Object> aggregatedObjects) {
		this.aggregatedObjects = aggregatedObjects;
	}
}
