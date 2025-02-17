package org.iesbelen.controller;

import org.iesbelen.domain.Categoria;
import org.iesbelen.dto.PeliculaDTO;
import org.iesbelen.service.CategoriaService;
import org.iesbelen.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoriaController {

    private final PeliculaService peliculaService;
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService, PeliculaService peliculaService) {
        this.categoriaService = categoriaService;
        this.peliculaService = peliculaService;
    }

    @GetMapping("/categorias")
    public String listar(Model model) {

        List<Categoria> listaCategoria = categoriaService.listAll();
        model.addAttribute("listaCategoria", listaCategoria);
        return "categorias/categorias";
    }

    @GetMapping("/categorias/{id}")
    public String detalle(Model model, @PathVariable int id) {

        Categoria categoria = categoriaService.one(id);
        //List<PeliculaDTO> peliculaDTO = peliculaService.listPeliculaDTO(id);
        //int totalPeliculas = peliculaService
        model.addAttribute("categoria", categoria);

        return "categorias/detalle-categorias";
    }

}
