package com.gamevault.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamevault.backend.model.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
}
