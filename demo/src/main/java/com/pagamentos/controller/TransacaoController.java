package com.pagamentos.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pagamentos.domain.Descricao;
import com.pagamentos.domain.FormaPagamento;
import com.pagamentos.domain.Transacao;
import com.pagamentos.repository.TransacaoRepository;

@RestController
public class TransacaoController {

	@GetMapping("/teste")
	public Transacao saidaTeste() {
		
		LocalDateTime dataHora = LocalDateTime.now();
		
		FormaPagamento formaPagamento = new FormaPagamento(null,"Á VISTA", 1);
		
		Descricao descricao = new Descricao(null, 4000.00 , dataHora, "Loja XYZ", 3467580936L , 6579689, "ATIVO");
		
		Transacao transacao = new Transacao (null, "234234*****234234", descricao , formaPagamento);
		
		return transacao;
		
		
		
	}

	@Autowired
	TransacaoRepository repository;

	public TransacaoController(TransacaoRepository repository) {
		this.repository = repository;
	}

	// Retorna lista com os pagamentos
	@GetMapping(value = "/transacao")
	public List<Transacao> get() {
		return repository.findAll();
	}

	// Retorna pagamento do id informado
	@GetMapping("/transacao/{id}")
	public Transacao getById(@PathVariable Long id) {
		return repository.findById(id).get();
	}

	// Salva o pagamento do parâmetro
	@PostMapping("/transacao")
	public Transacao save(@RequestBody Transacao transacao) {
		return repository.save(transacao);
	}

	// Atualiza o pagamento de id informado
	@PutMapping("/transacao/{id}")
	public Transacao update(@RequestBody Transacao transacao, @PathVariable Long id) {
		return repository.findById(id).map(t -> {
			t.setCartao(transacao.getCartao());
			t.setDescricao(transacao.getDescricao());
			t.setFormaPagamento(transacao.getFormaPagamento());
			return repository.save(t);
		}).orElseGet(() -> {
			transacao.setId(id);
			return repository.save(transacao);
		});
	}

	// Apaga o pagamaento de id informado
	@DeleteMapping(("/transacao/{id}"))
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
