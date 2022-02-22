package com.everton.internet.banking.repositories;

import com.everton.internet.banking.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
