package com.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagamentos.domain.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

}
