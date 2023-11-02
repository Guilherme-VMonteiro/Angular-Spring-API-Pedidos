package com.guigas.packs.controllers;

import java.util.List;

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

import com.guigas.packs.entities.Item;
import com.guigas.packs.services.ItemServices;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemServices services;
	
	@GetMapping()
	public List<Item> findAll(){
		return services.findAll();
	}
	
	@GetMapping("/{id}")
	public Item findByid(@PathVariable(value = "id") Long id){
		return services.findById(id);
	}
	
	@PostMapping
	public Item create(@RequestBody Item item) {
		return services.create(item);
	}
	
	@PutMapping
	public Item update(@RequestBody Item itemAtualizado) {
		return services.update(itemAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
}
