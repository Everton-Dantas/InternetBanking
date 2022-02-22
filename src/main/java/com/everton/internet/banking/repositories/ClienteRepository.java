package com.everton.internet.banking.repositories;

import com.everton.internet.banking.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
