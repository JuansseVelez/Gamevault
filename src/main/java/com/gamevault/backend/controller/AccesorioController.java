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

import com.gamevault.backend.model.Accesorio;
import com.gamevault.backend.service.AccesorioService;

@RestController
@RequestMapping("/accesorios")
public class AccesorioController {

    private final AccesorioService accesorioService;

    public AccesorioController(AccesorioService accesorioService) {
        this.accesorioService = accesorioService;
    }

    @GetMapping
    public List<Accesorio> obtenerTodos() {
        return accesorioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Accesorio obtenerPorId(@PathVariable Long id) {
        return accesorioService.obtenerPorId(id);
    }

    @PostMapping
    public Accesorio crear(@RequestBody Accesorio accesorio) {
        return accesorioService.crear(accesorio);
    }

    @PutMapping("/{id}")
    public Accesorio actualizar(@PathVariable Long id, @RequestBody Accesorio accesorio) {
        return accesorioService.actualizar(id, accesorio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        accesorioService.eliminar(id);
    }
}
