package com.guigas.packs.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import com.guigas.packs.entities.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private List<Long> itens_id;

	@Column(name = "data_pedido", nullable = false)
	private LocalDateTime dataDoPedido = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();

	@Column(name = "data_atualizacao_pedido", nullable = true)
	private LocalDateTime dataDaAtualizacaoPedido;

	@Column(name = "valor_pedido")
	private Long valorTotal;

	private Status status;

	public Pedido() {

	}

	public Pedido(Long id, List<Long> itens_id, LocalDateTime dataDoPedido, LocalDateTime dataDaAtualizacaoPedido,
			Long valorTotal, Status status) {
		this.id = id;
		this.itens_id = itens_id;
		this.dataDoPedido = dataDoPedido;
		this.dataDaAtualizacaoPedido = dataDaAtualizacaoPedido;
		this.valorTotal = valorTotal;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getItens_id() {
		return itens_id;
	}

	public void setItens_id(List<Long> itens_id) {
		this.itens_id = itens_id;
	}

	public LocalDateTime getDataDoPedido() {
		return dataDoPedido;
	}

	public void setDataDoPedido(LocalDateTime dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}

	public LocalDateTime getDataDaAtualizacaoPedido() {
		return dataDaAtualizacaoPedido;
	}

	public void setDataDaAtualizacaoPedido(LocalDateTime dataDaAtualizacaoPedido) {
		this.dataDaAtualizacaoPedido = dataDaAtualizacaoPedido;
	}

	public Long getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Long valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDaAtualizacaoPedido, dataDoPedido, id, itens_id, status, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(dataDaAtualizacaoPedido, other.dataDaAtualizacaoPedido)
				&& Objects.equals(dataDoPedido, other.dataDoPedido) && Objects.equals(id, other.id)
				&& Objects.equals(itens_id, other.itens_id) && status == other.status
				&& Objects.equals(valorTotal, other.valorTotal);
	}

}
