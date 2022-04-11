package com.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagamentos.domain.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
	
	

}
