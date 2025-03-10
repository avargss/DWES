package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = {"", "/"}, params = {"!buscar", "!ordenar"})
    // Mapping que excluye las rutas con params ! (negacion)
    public List<Categoria> all() {
        log.info("Accediendo a todas las categorías");
        return this.categoriaService.all();
    }

    @GetMapping(value = {"", "/"})
    public List<Categoria> all(@RequestParam("buscar") Optional<String> buscarOptional,
                               @RequestParam("ordenar") Optional<String> ordenarOptional) {
        log.info("Accediendo a todas las películas con filtro buscar: %s y ordenar: %s",
                buscarOptional.orElse("Void"),
                ordenarOptional.orElse("Void"));

        return this.categoriaService.allByQueryFilterStream(buscarOptional, ordenarOptional);
        //return this.categoriaService.allByQueryFiltersMethodQuery(buscarOptional, ordenarOptional);
        //return this.categoriaService.allByQueryFiltersAnnotationQuery(buscarOptional, ordenarOptional);
    }

    @GetMapping("/{id}/cantidadPeliculas")
    public int cantidadPeliculas(@PathVariable Long id) {
        return this.categoriaService.one(id).getPeliculas().size();
    }

    @PostMapping({"", "/"})
    public Categoria newCategoria(@RequestBody Categoria categoria) {
        return this.categoriaService.save(categoria);
    }

    @GetMapping("/{id}")
    public Categoria one(@PathVariable("id") Long id) {
        return this.categoriaService.one(id);
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