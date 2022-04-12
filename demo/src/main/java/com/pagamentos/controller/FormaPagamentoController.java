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

import com.pagamentos.domain.FormaPagamento;
import com.pagamentos.repository.FormaPagamentoRepository;

@RestController
public class FormaPagamentoController {
	
	
	

	@Autowired
	FormaPagamentoRepository repository;

	public FormaPagamentoController(FormaPagamentoRepository repository) {
		this.repository = repository;
	}

	// Retorna lista com os FormaPagamento
	@GetMapping(value = "/formapagamento")
	public List<FormaPagamento> get() {
		return repository.findAll();
	}

	// Retorna FormaPagamento do id informado
	@GetMapping("/formapagamento/{id}")
	public FormaPagamento getById(@PathVariable Long id) {
		return repository.findById(id).get();
	}

	// Salva o FormaPagamento do parâmetro
	@PostMapping("/formapagamento")
	public FormaPagamento save(@RequestBody FormaPagamento formaPagamento) {
		return repository.save(formaPagamento);
	}

	// Atualiza o FormaPagamento de id informado
	@PutMapping("/formapagamento/{id}")
	public FormaPagamento update(@RequestBody FormaPagamento formaPagamento, @PathVariable Long id) {
		return repository.findById(id).map(fp -> {
			fp.setTipo(formaPagamento.getTipo());
			fp.setParcelas(formaPagamento.getParcelas());
			return repository.save(fp);
		}).orElseGet(() -> {
			formaPagamento.setId(id);
			return repository.save(formaPagamento);
		});
	}

	// Apaga o FormaPagamento de id informado
	@DeleteMapping(("/formapagamento/{id}"))
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
