package com.everton.internet.banking.repositories;

import com.everton.internet.banking.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
