package com.guigas.packs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guigas.packs.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
