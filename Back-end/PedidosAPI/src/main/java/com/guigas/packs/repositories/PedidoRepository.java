package com.guigas.packs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guigas.packs.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}
