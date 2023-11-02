package com.guigas.packs.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_item", nullable = false)
	private String nomeItem;

	@Column(name = "imagem_item")
	private String imagemItem;

	@Column(name = "preco", nullable = false)
	private Long precoItem;

	public Item() {

	}

	public Item(Long id, String nomeItem, String imagemItem, Long precoItem) {
		this.id = id;
		this.nomeItem = nomeItem;
		this.imagemItem = imagemItem;
		this.precoItem = precoItem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getImagemItem() {
		return imagemItem;
	}

	public void setImagemItem(String imagemItem) {
		this.imagemItem = imagemItem;
	}

	public Long getPrecoItem() {
		return precoItem;
	}

	public void setPrecoItem(Long precoItem) {
		this.precoItem = precoItem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, imagemItem, nomeItem, precoItem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(id, other.id) && Objects.equals(imagemItem, other.imagemItem)
				&& Objects.equals(nomeItem, other.nomeItem) && Objects.equals(precoItem, other.precoItem);
	}

}
