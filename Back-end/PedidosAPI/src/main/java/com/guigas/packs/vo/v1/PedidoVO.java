package com.guigas.packs.vo.v1;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import com.guigas.packs.entities.enums.Status;

public class PedidoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private List<Long> itens_id;
	private LocalDateTime dataDoPedido = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
	private LocalDateTime dataDaAtualizacaoPedido;
	private Long valorTotal;
	private Status status;

	public PedidoVO() {

	}

	public PedidoVO(Long id, List<Long> itens_id, LocalDateTime dataDoPedido, LocalDateTime dataDaAtualizacaoPedido,
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
		PedidoVO other = (PedidoVO) obj;
		return Objects.equals(dataDaAtualizacaoPedido, other.dataDaAtualizacaoPedido)
				&& Objects.equals(dataDoPedido, other.dataDoPedido) && Objects.equals(id, other.id)
				&& Objects.equals(itens_id, other.itens_id) && status == other.status
				&& Objects.equals(valorTotal, other.valorTotal);
	}

}
