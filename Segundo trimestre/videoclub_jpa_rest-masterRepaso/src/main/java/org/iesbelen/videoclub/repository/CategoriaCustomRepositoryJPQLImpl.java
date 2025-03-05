package org.iesbelen.videoclub.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.iesbelen.videoclub.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaCustomRepositoryJPQLImpl implements CategoriaCustomRepository {

    @Autowired
    private EntityManager em;

    @Override
    public List<Categoria> queryCustomCategoria(Optional<String> buscarOptional, Optional<String> ordenarOptional) {
        // Construye la consulta JPQL base para seleccionar todas las categorías
        StringBuilder queryBuilder = new StringBuilder("SELECT C FROM Categoria C");

        // Si se proporciona un valor de búsqueda, agrega una cláusula WHERE para filtrar por nombre
        if (buscarOptional.isPresent()) {
            queryBuilder.append(" WHERE C.nombre LIKE :nombre");
        }

        // Si se proporciona un valor de ordenación, agrega una cláusula ORDER BY para ordenar por nombre
        if (ordenarOptional.isPresent()) {
            if (buscarOptional.isPresent() && "asc".equalsIgnoreCase(buscarOptional.get())) {
                queryBuilder.append(" ORDER BY C.nombre ASC");
            } else if (buscarOptional.isPresent() && "desc".equalsIgnoreCase(buscarOptional.get())) {
                queryBuilder.append(" ORDER BY C.nombre DESC");
            }
        }

        // Esto es una consulta JPQL, es decir, tiene sintaxis de SQL pero es con Entidades de JPA
        Query query = em.createQuery(queryBuilder.toString());

        // Si se proporciona un valor de búsqueda, establece el parámetro de búsqueda en la consulta
        if (buscarOptional.isPresent()) {
            query.setParameter("nombre", "%" + buscarOptional.get() + "%");
        }

        // Ejecuta la consulta y devuelve la lista de resultados
        return query.getResultList();
    }
}