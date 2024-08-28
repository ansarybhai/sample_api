package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		try {
			return new ResponseEntity<>(orderService.createOrder(order),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception is created:"+e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
