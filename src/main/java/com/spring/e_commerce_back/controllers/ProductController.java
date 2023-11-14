package com.spring.e_commerce_back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.e_commerce_back.entities.Product;
import com.spring.e_commerce_back.payloads.responseEntityMessages.FindAllMessage;
import com.spring.e_commerce_back.payloads.responseEntityMessages.UpdateProductMessage;
import com.spring.e_commerce_back.services.ProductService;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/findAll")
	public ResponseEntity<FindAllMessage> findAll(){
		return productService.findAll();
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<?> create(@RequestBody Product product){
		return productService.create(product);
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<UpdateProductMessage> update(@RequestBody Product product){
		return productService.update(product);
	}
	
	@DeleteMapping(path ="/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return productService.delete(id);
	}

}
