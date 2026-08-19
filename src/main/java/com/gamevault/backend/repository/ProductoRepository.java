package com.gamevault.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamevault.backend.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
