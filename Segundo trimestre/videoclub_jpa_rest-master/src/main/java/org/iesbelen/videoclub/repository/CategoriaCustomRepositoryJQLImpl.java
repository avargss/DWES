package org.iesbelen.videoclub.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.iesbelen.videoclub.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaCustomRepositoryJQLImpl implements CategoriaCustomRepository {

    @Autowired
    private EntityManager em;

    @Override
    public List<Categoria> queryCustomCategoria(Optional<String> buscarOptional, Optional<String> ordenarOptional) {
        StringBuilder queryBuilder = new StringBuilder("SELECT C FROM Categoria C");

        if (buscarOptional.isPresent()) {
            queryBuilder.append(" ").append(" WHERE C.nombre LIKE :nombre");
        }

        if (ordenarOptional.isPresent()) {
            if (buscarOptional.isPresent() && "asc".equalsIgnoreCase(buscarOptional.get())) {
                queryBuilder.append(" ").append("ORDER BY C.nombre ASC");
            } else if (buscarOptional.isPresent() && "desc".equalsIgnoreCase(buscarOptional.get())) {
                queryBuilder.append(" ").append("ORDER BY C.nombre DESC");
            }
        }

        // Esto es una consulta JPQL, es decir, tiene sintaxis de SQL pero es con Entidades de JPA
        Query query = em.createQuery(queryBuilder.toString());

        if (buscarOptional.isPresent()) {
            query.setParameter("nombre", "%" + buscarOptional.get() + "%");
        }
        return query.getResultList();
    }

}