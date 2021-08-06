package br.com.maycon.farmacia.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoModel {
	
	private static long count = 0;
	
	private Long id;
	private List<ItemCarrinhoModel> itens;
	private EnumStatusCarrinhoModel status;
	
	public CarrinhoModel() {
		this.id = ++count;
		this.itens = new ArrayList<ItemCarrinhoModel>();
		this.status = EnumStatusCarrinhoModel.AGUARDANDO;
	}
	
	public void addPerfume(PerfumeModel p, Integer qtd) {
		if (EnumStatusCarrinhoModel.FINALIZADO.equals(this.status)) {
			throw new RuntimeException("Carrinho finalizado");
		}
		this.itens.add(new ItemCarrinhoModel(p, qtd));
	}
	
	public BigDecimal getValorTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemCarrinhoModel itemCarrinhoModel : itens) {
			soma = soma.add(itemCarrinhoModel.getValorTotal());
		}
		return soma;
	}
	
	public void finalizar() {
		if (EnumStatusCarrinhoModel.FINALIZADO.equals(this.status)) {
			throw new RuntimeException("Carrinho finalizado");
		}
		this.status = EnumStatusCarrinhoModel.FINALIZADO;
	}

	public Long getId() {
		return id;
	}

	public List<ItemCarrinhoModel> getItens() {
		return itens;
	}

	public EnumStatusCarrinhoModel getStatus() {
		return status;
	}
	
	
 	
	
}
