package com.guigas.packs.services;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigas.packs.entities.Item;
import com.guigas.packs.entities.Pedido;
import com.guigas.packs.repositories.ItemRepository;
import com.guigas.packs.repositories.PedidoRepository;

@Service
public class PedidoServices {

	private Logger logger = Logger.getLogger(PedidoServices.class.getName());

	@Autowired
	PedidoRepository repositorio;

	@Autowired
	ItemRepository itemRepository;

	public Pedido findById(Long id) {

		logger.info("findById no pedido de id: " + id);

		return repositorio.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Nenhum pedido encontrado com esse ID: " + id));

	}

	public List<Pedido> findAll() {

		logger.info("Procurando todos os pedidos!");

		return repositorio.findAll();

	}

	public Pedido create(Pedido pedido) {

		logger.info("Criando um pedido!");

		for (Long itemId : pedido.getItens_id()) {
			if (itemRepository.findById(itemId) == null) {
				throw new NoSuchElementException("Nenhum item encontado com este id: " + itemId);
			}
		}
		pedido.setValorTotal(getPrecoTotal(pedido));

		return repositorio.save(pedido);
	}

	public Pedido update(Pedido pedido) {

		logger.info("Atualizando o pedido de id: " + pedido.getId());

		Pedido pedidoAtualizado = repositorio.findById(pedido.getId()).orElseThrow(
				() -> new NoSuchElementException("Nenhum pedido encontrado com esse ID: " + pedido.getId()));

		pedidoAtualizado.setItens_id(pedido.getItens_id());
		pedidoAtualizado.setStatus(pedido.getStatus());
		pedidoAtualizado.setDataDoPedido(pedido.getDataDoPedido());
		pedidoAtualizado
				.setDataDaAtualizacaoPedido(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toLocalDateTime());
		pedidoAtualizado.setValorTotal(getPrecoTotal(pedido));

		return repositorio.save(pedidoAtualizado);
	}

	public void delete(Long id) {

		logger.info("Deletando o pedido de id: " + id);

		Pedido pedidoADeletar = repositorio.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Nenhum pedido encontrado com esse ID: " + id));

		repositorio.delete(pedidoADeletar);
	}

	private Long getPrecoTotal(Pedido pedido) {
		Long precoTotal = 0L;

		for (Long item_id : pedido.getItens_id()) {
			Item itemAtual = itemRepository.findById(item_id)
					.orElseThrow(() -> new NoSuchElementException("Nenhum item encontrado com esse ID: " + item_id));
			precoTotal += itemAtual.getPrecoItem();
		}
		return precoTotal;
	}
}
