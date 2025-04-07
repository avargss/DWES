package org.iesbelen.examenspringbootjpa.service;

import org.iesbelen.examenspringbootjpa.domain.Product;
import org.iesbelen.examenspringbootjpa.exception.ProductNotFoundException;
import org.iesbelen.examenspringbootjpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> all() {
        return this.productRepository.findAll();
    }

    public Product one(Long id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        return this.productRepository.findById(id).map(p -> (id.equals(product.getId()) ?
                        this.productRepository.save(product) : null))
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void delete(Long id) {
        this.productRepository.findById(id).map(p -> {
                    this.productRepository.delete(p);
                    return p;
                })
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> obtenerProductosOrdenados(String ordenar) {
        Sort sort = Sort.by(Sort.Order.asc("name"));

        if (ordenar != null && !ordenar.isEmpty()) {
            String[] parts = ordenar.split(",");
            if (parts.length == 2) {
                String campo = parts[0];
                String sentido = parts[1];
                if ((campo.equals("price") || campo.equals("name")) && (sentido.equalsIgnoreCase("asc") || sentido.equalsIgnoreCase("desc"))) {
                    Sort.Order order = (sentido.equalsIgnoreCase("desc"))
                            ? Sort.Order.desc(campo)
                            : Sort.Order.asc(campo);
                    sort = Sort.by(order);
                }
            }
        }

        return productRepository.findAll(sort);
    }

    public Map<String, Object> paginarPorPaginaTamanio(int pagina, int tamanio) {
        Pageable paginado = PageRequest.of(pagina, tamanio, Sort.by("id").ascending());

        Page<Product> pageAll = this.productRepository.findAll(paginado);

        Map<String, Object> response = new HashMap<>();

        response.put("productos", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalItems", pageAll.getTotalElements());
        response.put("totalPages", pageAll.getTotalPages());

        return response;
    }

    public List<Product> buscarProductos(String buscar) {
        String campo = "name";
        String valor = "";

        if (buscar != null && !buscar.isEmpty()) {
            String[] parts = buscar.split(",");
            if (parts.length == 2) {
                campo = parts[0];
                valor = parts[1];
            }
        }

        switch (campo) {
            case "descrip":
                return productRepository.findByDescripContaining(valor);
            case "price":
                double price = Double.parseDouble(valor);
                return productRepository.findByPrice(price);
            case "quantity":
                int quantity = Integer.parseInt(valor);
                return productRepository.findByQuantity(quantity);
            default:
                return productRepository.findByNameContaining(valor);
        }
    }



}
