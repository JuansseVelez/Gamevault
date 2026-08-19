package com.gamevault.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamevault.backend.model.Consola;

public interface ConsolaRepository extends JpaRepository<Consola, Long> {
}
