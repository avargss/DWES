package org.iesbelen.examenspringbootjpa.repository;

import org.iesbelen.examenspringbootjpa.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);

    List<Product> findByDescripContaining(String descrip);

    List<Product> findByPrice(double price);

    List<Product> findByQuantity(int quantity);

}
