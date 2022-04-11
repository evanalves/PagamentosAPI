package com.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagamentos.domain.Transacao;
@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
	
	

}
