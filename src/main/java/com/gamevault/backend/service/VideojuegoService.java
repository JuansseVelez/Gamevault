package com.gamevault.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gamevault.backend.model.Videojuego;
import com.gamevault.backend.repository.VideojuegoRepository;

@Service
public class VideojuegoService {

    private final VideojuegoRepository videojuegoRepository;

    public VideojuegoService(VideojuegoRepository videojuegoRepository) {
        this.videojuegoRepository = videojuegoRepository;
    }

    public List<Videojuego> obtenerTodos() {
        return videojuegoRepository.findAll();
    }

    public Videojuego obtenerPorId(Long id) {
        return videojuegoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Videojuego no encontrado con id: " + id));
    }

    public Videojuego crear(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    public Videojuego actualizar(Long id, Videojuego datosNuevos) {
        Videojuego existente = obtenerPorId(id);
        existente.setNombre(datosNuevos.getNombre());
        existente.setPrecio(datosNuevos.getPrecio());
        existente.setGenero(datosNuevos.getGenero());
        existente.setPlataforma(datosNuevos.getPlataforma());
        return videojuegoRepository.save(existente);
    }

    public void eliminar(Long id) {
        if (!videojuegoRepository.existsById(id)) {
            throw new RuntimeException("Videojuego no encontrado con id: " + id);
        }
        videojuegoRepository.deleteById(id);
    }
}
