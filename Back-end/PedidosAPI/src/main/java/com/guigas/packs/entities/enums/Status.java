package com.guigas.packs.entities.enums;

public enum Status {

	ENTREGUE("Entregue"), PRONTO("Pronto"), EM_PRODUCAO("Em produção"), A_FAZER("A fazer");

	private String status;

	Status(String enumStatus) {
		this.status = enumStatus;
	}

	public String getStatus() {
		return this.status;
	}

}
