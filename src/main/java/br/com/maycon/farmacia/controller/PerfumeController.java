package br.com.maycon.farmacia.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.maycon.farmacia.armazenamento.SalvaDados;
import br.com.maycon.farmacia.model.EnumTipoPerfumeModel;
import br.com.maycon.farmacia.model.PerfumeModel;

@RestController
@RequestMapping("/perfume")
public class PerfumeController {

	@GetMapping("/cadastrar")
	public PerfumeModel cadastrar(@RequestParam String nome, @RequestParam BigDecimal valor, @RequestParam EnumTipoPerfumeModel tipo) {
		PerfumeModel p = new PerfumeModel(nome, valor, tipo);
		SalvaDados.perfumes.add(p);
		return p;
	}
	
	@GetMapping("/alterar")
	public PerfumeModel alterar(@RequestParam Long id, @RequestParam String nome, @RequestParam BigDecimal valor, @RequestParam EnumTipoPerfumeModel tipo) {
		for (PerfumeModel p : SalvaDados.perfumes) {
			if (id.equals(p.getId())) {
				p.alterar(nome, valor, tipo);
				return p;
			}
		}
		return null;
	}
	
	@GetMapping("/remover")
	public PerfumeModel remover(@RequestParam Long id) {
		for (PerfumeModel p : SalvaDados.perfumes) {
			if (id.equals(p.getId())) {
				SalvaDados.perfumes.remove(p);
				return p;
			}
		}
		return null;
	}
	
	@GetMapping("/listar")
	public List<PerfumeModel> listar() {
		return SalvaDados.perfumes;
	}
}
