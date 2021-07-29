package com.sapient.oms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.sapient.oms.entity.CustomerOrderMaster;
import com.sapient.oms.exception.OrderException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api
@RestController
@RequestMapping("/om")
public class OmsController {


	//http://localhost:8081/oms/v1/orders/1
	@ApiOperation(value = "Find order by id",
			consumes = "user id",
			produces = "CustomerOrderMaster object",
			response = CustomerOrderMaster.class,
			tags = "findOrderById",
			notes = "http://localhost:8081/oms/v1/orders/1")
	@GetMapping("/orders/{id}")
	public ResponseEntity<CustomerOrderMaster> findOrderById(@Valid @PathVariable("id") Integer id) throws OrderException{
		CustomerOrderMaster order = new CustomerOrderMaster(id,145L,LocalDate.of(2020, 10, 30),100.00,5,
				45.00,60.00,"UPI","INR",23,"SS-002");
		return new ResponseEntity<>(order,HttpStatus.OK);
	}

	// http://localhost:8081/cms/v1/orders
	@ApiOperation(value = "Add order",
			consumes = "CustomerOrderMaster object",
			produces = "CustomerOrderMaster object",
			tags = "postOrder",
			notes = "http://localhost:8081/oms/v1/orders")
	@PostMapping("/orders")
	public ResponseEntity<CustomerOrderMaster> addOrder(@RequestBody CustomerOrderMaster order,
			BindingResult bindingResult) throws OrderException{
		try {
			if(bindingResult.hasErrors()) {
				throw new OrderException(bindingResult.getAllErrors().toString());
			}
			return new ResponseEntity<>(order,HttpStatus.OK);
		}catch(OrderException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}


	// http://localhost:8081/cms/v1/orders
	@ApiOperation(value = "Get all orders",
			produces = "List of CustomerOrderMaster objects",
			tags = "getAllOrder",
			notes = "http://localhost:8081/oms/v1/orders")
	@GetMapping("/orders")
	public ResponseEntity<List<CustomerOrderMaster>> getAllOrders(){
		try {
			List<CustomerOrderMaster> orderList = new ArrayList<>();
			CustomerOrderMaster order1 = new CustomerOrderMaster(1,145L,LocalDate.of(2020, 10, 30),100.00,5,
					45.00,60.00,"UPI","INR",23,"SS-002");
			CustomerOrderMaster order2 = new CustomerOrderMaster(2,150L,LocalDate.of(2010, 05, 12),150.62,10,
					75.5,50.5,"Cash","USD",24,"IT-009");
			orderList.add(order1);
			orderList.add(order2);
			return new ResponseEntity<>(orderList,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}

	}

	// http://localhost:8081/cms/v1/orders
	@ApiOperation(value = "Update order",
			consumes = "CustomerOrderMaster object",
			produces = "CustomerOrderMaster object",
			response = CustomerOrderMaster.class,
			tags = "updateOrder",
			notes = "http://localhost:8081/oms/v1/orders")
	@PutMapping("/orders")
	public ResponseEntity<CustomerOrderMaster> updateOrder(@Valid @RequestBody CustomerOrderMaster order,
			BindingResult bindingResult) throws OrderException{
		try {
			if(bindingResult.hasErrors()) {
				throw new OrderException(bindingResult.getAllErrors().toString());
			}
			return new ResponseEntity<>(order,HttpStatus.OK);
		}catch(OrderException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}

	// http://localhost:8081/cms/v1/orders/1
	@ApiOperation(value = "Delete order by id",
			consumes = "user id",
			produces = "user id of the deleted object",
			response = Integer.class,
			tags = "deleteOrder",
			notes = "http://localhost:8081/oms/v1/orders/1")
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Integer> deleteOrder(@PathVariable("id") Integer id){
		try {
			CustomerOrderMaster order = new CustomerOrderMaster(2,150L,LocalDate.of(2010, 05, 12),150.62,10,
					75.5,50.5,"Cash","USD",24,"IT-009");
			return ResponseEntity.ok(id);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}

	}

}
