package org.iesbelen.controller;

import jakarta.validation.Valid;
import org.iesbelen.domain.Pelicula;
import org.iesbelen.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PeliculaController {

    private PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("/peliculas")
    public String listar(Model model) {

        List<Pelicula> listaPelicula = peliculaService.listAll();
        model.addAttribute("listaPelicula", listaPelicula);
        return "peliculas/peliculas";
    }

    @GetMapping("/peliculas/crear")
    public String crear(Model model) {

        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);

        return "peliculas/crear-pelicula";
    }

    @PostMapping("/peliculas/crear")
    public String submitCrear(@ModelAttribute("pelicula") @Valid Pelicula pelicula, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pelicula", pelicula);
            return "peliculas/crear-pelicula";
        }
        peliculaService.newPelicula(pelicula);
        return "redirect:/peliculas/crear";

    }

}
