package com.guigas.packs.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigas.packs.entities.Item;
import com.guigas.packs.repositories.ItemRepository;

@Service
public class ItemServices {

	@Autowired
	ItemRepository repository;

	public Item findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Nenhum item encontrado com esse ID: " + id));
	}

	public List<Item> findAll() {
		return repository.findAll();
	}

	public Item create(Item item) {
		return repository.save(item);
	}

	public Item update(Item item) {
		Item itemAAtualizar = repository.findById(item.getId())
				.orElseThrow(() -> new NoSuchElementException("Nenhum item encontrado com esse ID: " + item.getId()));

		itemAAtualizar.setNomeItem(item.getNomeItem());
		itemAAtualizar.setImagemItem(item.getImagemItem());
		itemAAtualizar.setPrecoItem(item.getPrecoItem());

		return repository.save(itemAAtualizar);
	}

	public void delete(Long id) {
		Item itemADeletar = repository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Nenhum item encontrado com esse ID: " + id));

		repository.delete(itemADeletar);
	}
}
