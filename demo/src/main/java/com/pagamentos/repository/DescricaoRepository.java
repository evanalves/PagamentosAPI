package com.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pagamentos.domain.Descricao;
@Repository
public interface DescricaoRepository extends JpaRepository<Descricao, Long> {

}
