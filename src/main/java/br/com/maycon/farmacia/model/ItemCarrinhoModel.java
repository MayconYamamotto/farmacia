package br.com.maycon.farmacia.model;

import java.math.BigDecimal;

public class ItemCarrinhoModel {
	
	private static long count = 0;
	
	private Long id;
	private PerfumeModel perfume;
	private Integer qtd;
	private BigDecimal valorTotal;
	
	public ItemCarrinhoModel(PerfumeModel p, Integer qtd) {
		this.id = ++count;
		this.perfume = p;
		this.qtd = qtd;
		this.valorTotal = p.getValor().multiply(BigDecimal.valueOf(qtd));
	}

	public Long getId() {
		return id;
	}

	public PerfumeModel getPerfumeModel() {
		return perfume;
	}

	public Integer getQtd() {
		return qtd;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}	
}
