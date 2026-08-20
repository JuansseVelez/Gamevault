package com.gamevault.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gamevault.backend.model.Accesorio;
import com.gamevault.backend.repository.AccesorioRepository;

@Service
public class AccesorioService {

    private final AccesorioRepository accesorioRepository;

    public AccesorioService(AccesorioRepository accesorioRepository) {
        this.accesorioRepository = accesorioRepository;
    }

    public List<Accesorio> obtenerTodos() {
        return accesorioRepository.findAll();
    }

    public Accesorio obtenerPorId(Long id) {
        return accesorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accesorio no encontrado con id: " + id));
    }

    public Accesorio crear(Accesorio accesorio) {
        return accesorioRepository.save(accesorio);
    }

    public Accesorio actualizar(Long id, Accesorio datosNuevos) {
        Accesorio existente = obtenerPorId(id);
        existente.setNombre(datosNuevos.getNombre());
        existente.setPrecio(datosNuevos.getPrecio());
        existente.setMarca(datosNuevos.getMarca());
        existente.setCompatibilidad(datosNuevos.getCompatibilidad());
        existente.setCategoria(datosNuevos.getCategoria());
        return accesorioRepository.save(existente);
    }

    public void eliminar(Long id) {
        if (!accesorioRepository.existsById(id)) {
            throw new RuntimeException("Accesorio no encontrado con id: " + id);
        }
        accesorioRepository.deleteById(id);
    }
}
