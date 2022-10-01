package com.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.studentResp.StudentResponse;

@RestController
public class StudentController {
	
	@GetMapping("/studentgetAll")
	public String getStudent() {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		String resp=restTemplate.getForObject("localhost:8081/api/all", String.class);
		System.out.println(resp);
		try {
			StudentResponse stu=mapper.readValue(resp, StudentResponse.class);
			System.out.println(stu.toString());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
		
	}

}
