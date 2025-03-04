package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categoriasRepaso")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // MÉTODO ALL BÁSICO
    @GetMapping(value = {"","/"}, params = {"!buscar", "!ordenar"})
    public List<Categoria> all() {
        log.info("Accediendo a todas las categorías");
        return this.categoriaService.all();
    }

    // MÉTODO ALL CON FILTRO Y ORDENACIÓN
    @GetMapping(value = {"","/"})
    public List<Categoria> all(
            @RequestParam("buscar") Optional<String> buscarOptional,
            @RequestParam("ordenar") Optional<String> ordenarOptional) {

        log.info("Accediendo a todas las peliculas con el filtro buscar: %s y ordenar por: %s",
                buscarOptional.orElse("VOID"),
                ordenarOptional.orElse("VOID"));

        return this.categoriaService.allByQueryFilterStream(buscarOptional, ordenarOptional);
    }

    // MÉTODO QUE DEVUELVE LA CANTIDAD DE PELÍCULAS DE UNA CATEGORÍA
    @GetMapping("/{id}/cantidadPeliculas")
    public int cantidadPeliculas(@PathVariable Long id) {
        return this.categoriaService.one(id).getPeliculas().size();
    }

    // MÉTODO QUE DEVUELVE UNA CATEGORÍA POR SU ID
    @GetMapping("/{id}")
    public Categoria one(@PathVariable("id") Long id) {
        return this.categoriaService.one(id);
    }

    @PostMapping({"","/"})
    public Categoria newCategoria(@RequestBody Categoria categoria) {
        return this.categoriaService.save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria replaceCategoria(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
        return this.categoriaService.replace(id, categoria);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable("id") Long id) {
        this.categoriaService.delete(id);
    }
}
