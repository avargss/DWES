package org.iesbelen.examenspringbootjpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.examenspringbootjpa.domain.Product;
import org.iesbelen.examenspringbootjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"", "/"}, params = {"!buscar", "!pagina", "!tamanio", "!ordenar"})
    public List<Product> all() {
        log.info("Accediendo a todos los productos");
        return this.productService.all();
    }

    @GetMapping("/{id}")
    public Product one(@PathVariable("id") Long id) {
        return this.productService.one(id);
    }

    @PostMapping({"", "/"})
    public Product create(@RequestBody Product product) {
        return this.productService.create(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable("id") Long id, @RequestBody Product product) {
        return this.productService.update(id, product);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.productService.delete(id);
    }

    @GetMapping(value = {"", "/"}, params = {"ordenar"})
    public List<Product> obtenerProductosOrdenados(@RequestParam(value = "ordenar", required = false) String ordenar) {
        return this.productService.obtenerProductosOrdenados(ordenar);
    }

    @GetMapping(value = {"", "/"}, params = {"pagina", "tamanio"})
    public ResponseEntity<Map<String, Object>> paginarPorPaginaTamanio(
            @RequestParam(value = "pagina", defaultValue = "0") int pagina,
            @RequestParam(value = "tamanio", defaultValue = "10") int tamanio) {

        log.info("Accediendo a todas las peliculas con paginación");

        Map<String, Object> responseAll = this.productService.paginarPorPaginaTamanio(pagina, tamanio);
        return ResponseEntity.ok(responseAll);
    }

    @GetMapping(value = {"", "/"}, params = {"buscar"})
    public List<Product> buscarProductos(@RequestParam(value = "buscar", required = false) String buscar) {
        return this.productService.buscarProductos(buscar);
    }
}
