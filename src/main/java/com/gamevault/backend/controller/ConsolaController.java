package com.gamevault.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamevault.backend.model.Consola;
import com.gamevault.backend.service.ConsolaService;

@RestController
@RequestMapping("/consolas")
public class ConsolaController {

    private final ConsolaService consolaService;

    public ConsolaController(ConsolaService consolaService) {
        this.consolaService = consolaService;
    }

    @GetMapping
    public List<Consola> obtenerTodos() {
        return consolaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Consola obtenerPorId(@PathVariable Long id) {
        return consolaService.obtenerPorId(id);
    }

    @PostMapping
    public Consola crear(@RequestBody Consola consola) {
        return consolaService.crear(consola);
    }

    @PutMapping("/{id}")
    public Consola actualizar(@PathVariable Long id, @RequestBody Consola consola) {
        return consolaService.actualizar(id, consola);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        consolaService.eliminar(id);
    }
}
