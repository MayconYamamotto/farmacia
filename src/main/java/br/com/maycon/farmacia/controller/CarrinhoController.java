package br.com.maycon.farmacia.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.maycon.farmacia.armazenamento.SalvaDados;
import br.com.maycon.farmacia.model.CarrinhoModel;
import br.com.maycon.farmacia.model.EnumTipoPerfumeModel;
import br.com.maycon.farmacia.model.PerfumeModel;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	@GetMapping("/cadastrar")
	public CarrinhoModel cadastrar() {
		CarrinhoModel c = new CarrinhoModel();
		SalvaDados.carrinhoModel.add(c);
		return c;
	}

	@GetMapping("/addPerfume")
	public CarrinhoModel addPerfume(@RequestParam Long id, @RequestParam Long idP, @RequestParam Integer qtd) {
		for (CarrinhoModel carts : SalvaDados.carrinhoModel) {
			if (carts.getId().equals(id)) {
				for (PerfumeModel perfumes : SalvaDados.perfumes) {
					if (id.equals(perfumes.getId())) {
						carts.addPerfume(perfumes, qtd);
						return carts;
					}
				}
			}
		}
		return null;
	}

	@GetMapping("/alterarPerfume")
	public CarrinhoModel alterarPerfume(@RequestParam Long id, @RequestParam Long idP, @RequestParam Integer qtd) {
		
		return null;
	}

	@GetMapping("/remover")
	public CarrinhoModel remover(@RequestParam Long id) {
		for (CarrinhoModel c : SalvaDados.carrinhoModel) {
			if (id.equals(c.getId())) {
				SalvaDados.carrinhoModel.remove(c);
				return c;
			}
		}
		return null;
	}

	@GetMapping("/listar")
	public List<CarrinhoModel> listar() {
		return SalvaDados.carrinhoModel;
	}
}
