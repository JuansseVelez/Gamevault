package com.gamevault.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gamevault.backend.model.Accesorio;
import com.gamevault.backend.model.Consola;
import com.gamevault.backend.model.Videojuego;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);

        Videojuego minecraft = new Videojuego(
                1L,
                "Minecraft",
                120000,
                "Sandbox",
                "PC"
        );
        System.out.println(minecraft);

        Consola playstation5 = new Consola(
                2L,
                "Play Station 5",
                2500000,
                "Sony",
                "Sobremesa",
                "Digital y disco"
        );
        System.out.println(playstation5);

        Accesorio controlS5 = new Accesorio(
                3L,
                "Control PS5 DualSense",
                250000,
                "Sony",
                "Play Station 5",
                "Control"
        );
        System.out.println(controlS5);
    }

}
