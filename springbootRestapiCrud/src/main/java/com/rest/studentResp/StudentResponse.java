package com.rest.studentResp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StudentResponse {

	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	@JsonProperty("address")
	private String address;
	@Override
	public String toString() {
		return getString();
	}
	public String getString() {
		StringBuilder builder = new StringBuilder();
		builder.append("name = "+ getName());
		builder.append("email = "+getEmail());
		builder.append("address = "+ getAddress());
		return builder.toString();
	}
	
}
