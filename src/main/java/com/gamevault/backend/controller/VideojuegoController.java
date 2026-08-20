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

import com.gamevault.backend.model.Videojuego;
import com.gamevault.backend.service.VideojuegoService;

@RestController
@RequestMapping("/videojuegos")
public class VideojuegoController {

    private final VideojuegoService videojuegoService;

    public VideojuegoController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }

    @GetMapping
    public List<Videojuego> obtenerTodos() {
        return videojuegoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Videojuego obtenerPorId(@PathVariable Long id) {
        return videojuegoService.obtenerPorId(id);
    }

    @PostMapping
    public Videojuego crear(@RequestBody Videojuego videojuego) {
        return videojuegoService.crear(videojuego);
    }

    @PutMapping("/{id}")
    public Videojuego actualizar(@PathVariable Long id, @RequestBody Videojuego videojuego) {
        return videojuegoService.actualizar(id, videojuego);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        videojuegoService.eliminar(id);
    }
}
