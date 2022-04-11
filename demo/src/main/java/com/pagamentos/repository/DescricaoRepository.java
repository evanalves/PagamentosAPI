package com.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagamentos.domain.Descricao;

public interface DescricaoRepository extends JpaRepository<Descricao, Long> {

}
