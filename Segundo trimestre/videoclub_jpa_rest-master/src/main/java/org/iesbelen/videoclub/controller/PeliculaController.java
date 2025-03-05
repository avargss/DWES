package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Actor;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.domain.Pelicula;
import org.iesbelen.videoclub.service.ActorService;
import org.iesbelen.videoclub.service.CategoriaService;
import org.iesbelen.videoclub.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ActorService actorService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping(value = {"", "/"}, params = {"!paginacion", "!orden", "!pagina", "!tamanio"})
    public List<Pelicula> all() {
        log.info("Accediendo a todas las películas");
        return this.peliculaService.all();
    }

    @GetMapping("/{id}")
    public Pelicula one(@PathVariable("id") Long id) {
        return this.peliculaService.one(id);
    }

    // PARA QUE ME ORDENE LAS PELICULAS POR COLUMNA, SENTIDO (localhost:8080/peliculas?orden=idPelicula,desc)
    @GetMapping(value = {"", "/"}, params = {"!paginacion", "!tamanio"})
    public ResponseEntity<List<Pelicula>> obtenerPeliculas(
            @RequestParam(required = false) String orden) {

        // Si no se pasa ningún parámetro 'orden', el valor será null
        List<Pelicula> peliculas = peliculaService.obtenerPeliculasOrdenadas(orden);
        return ResponseEntity.ok(peliculas);
    }

    // PARA QUE ME PAGINE USANDO PAGINA Y TAMANIO (localhost:8080/peliculas?pagina=0&tamanio=5)
    @GetMapping(value = {"", "/"}, params = {"!paginacion", "!orden"})
    public ResponseEntity<Map<String, Object>> all(
            @RequestParam(value = "pagina", defaultValue = "0") int pagina,
            @RequestParam(value = "tamanio", defaultValue = "0") int tamanio) {

        log.info("Accediendo a todas las peliculas con paginación");

        Map<String, Object> responseAll = this.peliculaService.all(pagina, tamanio);
        return ResponseEntity.ok(responseAll);
    }

    // PARA QUE ME HAGA LA PAGINACION CON UN SOLO PARAMETRO PAGINACION (http://localhost:8080/peliculas?paginacion=0,2)
    @GetMapping(value = {"", "/"}, params = {"!orden", "!pagina", "!tamanio"})
    public ResponseEntity<Map<String, Object>> all(
            @RequestParam(value = "paginacion", defaultValue = "0, 10") String[] paginacion) {

        log.info("Accediendo a todas las peliculas con paginación");

        Map<String, Object> responseAll = this.peliculaService.all(paginacion);
        return ResponseEntity.ok(responseAll);
    }

    @GetMapping(value = "/order")
    public List<Pelicula> allOrdered() {
        log.info("Accediendo a todas las películas ordenadas");
        return this.peliculaService.findAllByOrderByTituloAsc();
    }


    @PostMapping({"", "/"})
    public Pelicula newPelicula(@RequestBody Pelicula pelicula) {
        return this.peliculaService.save(pelicula);
    }

    @PostMapping("/{id}/addCategoria/{id_categoria}")
    public void addCategoriaToPelicula(@PathVariable("id") long id, @PathVariable("id_categoria") long id_categoria) {

        Categoria categoriaNueva = categoriaService.one(id_categoria); // Me encuentra la categoria
        Pelicula pelicula = peliculaService.one(id); // Me encuentra la pelicula

        pelicula.getCategorias().add(categoriaNueva); // Añado la categoria a la pelicula
        categoriaNueva.getPeliculas().add(pelicula);

        this.peliculaService.replace(id, pelicula);
        this.categoriaService.replace(id_categoria, categoriaNueva);
    }

    @PostMapping("/{id}/addActor/{id_actor}")
    public Pelicula addActorToPelicula(@PathVariable("id") long id, @PathVariable("id_actor") long id_actor) {

        Actor nuevoActor = actorService.one(id_actor); // Me encuentra el actor
        Pelicula pelicula = peliculaService.one(id); // Me encuentra la pelicula

        pelicula.getActores().add(nuevoActor);
        nuevoActor.getPeliculas().add(pelicula);

        this.peliculaService.replace(id, pelicula);
        this.actorService.replace(id_actor, nuevoActor);

        return null;
    }


    @PutMapping("/{id}")
    public Pelicula replacePelicula(@PathVariable("id") Long id, @RequestBody Pelicula pelicula) {
        return this.peliculaService.replace(id, pelicula);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable("id") Long id) {
        this.peliculaService.delete(id);
    }

}
