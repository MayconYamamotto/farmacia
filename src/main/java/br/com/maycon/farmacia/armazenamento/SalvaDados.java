package br.com.maycon.farmacia.armazenamento;

import java.util.ArrayList;
import java.util.List;

import br.com.maycon.farmacia.model.CarrinhoModel;
import br.com.maycon.farmacia.model.PerfumeModel;

public class SalvaDados {
	
	private SalvaDados() {}
	
	public static List<PerfumeModel> perfumes = new ArrayList<>();
	public static List<CarrinhoModel> carrinhoModel = new ArrayList<>();

}
