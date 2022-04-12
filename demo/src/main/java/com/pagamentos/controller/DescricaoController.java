package com.pagamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pagamentos.domain.Descricao;
import com.pagamentos.repository.DescricaoRepository;

@RestController
public class DescricaoController {
	


	
	
	@Autowired
	DescricaoRepository repository;

	public DescricaoController(DescricaoRepository repository) {
		this.repository = repository;
	}

	// Retorna lista com as pagamentos
	@GetMapping(value = "/descricao")
	public List<Descricao> get() {
		return repository.findAll();
	}

	//Retorna pagamento do id informado
	@GetMapping("/pagamentos/{id}")
	public Descricao getById(@PathVariable Long id) {
		return repository.findById(id).get();
	}

	// Salva o pagamento do parâmetro
	@PostMapping("/descricao")
	public Descricao save(@RequestBody Descricao descricao) {
		return repository.save(descricao);
	}

	// Atualiza o pagamento de id informado
	@PutMapping("/descricao/{id}")
	public Descricao update(@RequestBody Descricao descricao, @PathVariable Long id) {
		return repository.findById(id).map( d -> {
			d.setValor(descricao.getValor());
			d.setDataHora(descricao.getDataHora());
			d.setEstabelecimento(descricao.getEstabelecimento());
			d.setNsu(descricao.getNsu());
			d.setCodigoAutorizacao(descricao.getCodigoAutorizacao());
			d.setStatus(descricao.getStatus());
			return repository.save(d);
		}).orElseGet(() -> {
			descricao.setId(id);
			return repository.save(descricao);
		});
	}

	// Apaga o pagamaento de id informado
	@DeleteMapping(("/descricao/{id}"))
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
