package com.gamevault.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gamevault.backend.model.Consola;
import com.gamevault.backend.repository.ConsolaRepository;

@Service
public class ConsolaService {

    private final ConsolaRepository consolaRepository;

    public ConsolaService(ConsolaRepository consolaRepository) {
        this.consolaRepository = consolaRepository;
    }

    public List<Consola> obtenerTodos() {
        return consolaRepository.findAll();
    }

    public Consola obtenerPorId(Long id) {
        return consolaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consola no encontrada con id: " + id));
    }

    public Consola crear(Consola consola) {
        return consolaRepository.save(consola);
    }

    public Consola actualizar(Long id, Consola datosNuevos) {
        Consola existente = obtenerPorId(id);
        existente.setNombre(datosNuevos.getNombre());
        existente.setPrecio(datosNuevos.getPrecio());
        existente.setMarca(datosNuevos.getMarca());
        existente.setTipo(datosNuevos.getTipo());
        existente.setSoporte(datosNuevos.getSoporte());
        return consolaRepository.save(existente);
    }

    public void eliminar(Long id) {
        if (!consolaRepository.existsById(id)) {
            throw new RuntimeException("Consola no encontrada con id: " + id);
        }
        consolaRepository.deleteById(id);
    }
}
