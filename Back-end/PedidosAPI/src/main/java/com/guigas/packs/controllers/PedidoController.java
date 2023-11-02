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

import com.guigas.packs.entities.Pedido;
import com.guigas.packs.services.PedidoServices;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	PedidoServices services;
	
	@GetMapping()
	public List<Pedido> findAll(){
		return services.findAll();
	}
	
	@GetMapping("/{id}")
	public Pedido findByid(@PathVariable(value = "id") Long id){
		return services.findById(id);
	}
	
	@PostMapping
	public Pedido create(@RequestBody Pedido pedido) {
		return services.create(pedido);
	}
	
	@PutMapping
	public Pedido update(@RequestBody Pedido pedidoAtualizado) {
		return services.update(pedidoAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
}

