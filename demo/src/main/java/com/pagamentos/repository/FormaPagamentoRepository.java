package com.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagamentos.domain.FormaPagamento;
@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

}
