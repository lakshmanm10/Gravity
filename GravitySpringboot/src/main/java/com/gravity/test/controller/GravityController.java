package com.gravity.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gravity.test.model.RequestArray;
import com.gravity.test.model.ResponseVal;
import com.gravity.test.service.GravityService;

@RestController
public class GravityController {

	@Autowired
	GravityService gravityService;
	
	@PostMapping("/firstOffer")
	public ResponseEntity<ResponseVal> firstOffer(@RequestBody RequestArray requestArray) throws Exception{
	
		return ResponseEntity.ok(gravityService.firstOffer(requestArray));
		
	}
	
	@PostMapping("/secondOffer")
	public ResponseEntity<ResponseVal> secondOffer(@RequestBody RequestArray requestArray) throws Exception{
	
		return ResponseEntity.ok(gravityService.secondOffer(requestArray));
		
	}
	
	@PostMapping("/thirdOffer")
	public ResponseEntity<ResponseVal> thirdOffer(@RequestBody RequestArray requestArray) throws Exception{
	
		return ResponseEntity.ok(gravityService.thirdOffer(requestArray));
		
	}
}
