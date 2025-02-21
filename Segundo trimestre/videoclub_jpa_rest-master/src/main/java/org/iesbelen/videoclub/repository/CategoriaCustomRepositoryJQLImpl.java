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
        StringBuilder queryBuilder = new StringBuilder("SELECT c FROM Categoria c");

        if (buscarOptional.isPresent()) {
            queryBuilder.append(" WHERE c.nombre LIKE :nombre");
        }

        if (ordenarOptional.isPresent()) {
            if ("asc".equalsIgnoreCase(ordenarOptional.get())) {
                queryBuilder.append(" ").append("ORDER BY C.nombre ASC");
            } else if ("desc".equalsIgnoreCase(ordenarOptional.get())) {
                queryBuilder.append(" ").append("ORDER BY C.nombre DESC");
            }
        }

        Query query = em.createQuery(queryBuilder.toString());

        if (buscarOptional.isPresent()) {
            query.setParameter("nombre", "%" + buscarOptional.get() + "%");
        }
        return query.getResultList();
    }

    /* @project Necesito implementar un método
    en mi proyecto que me permita buscar
    categorias por el nombre y ordenarlas de
    forma ascendente o descendente. Ayudame a
    hacerlo y explicame paso a paso qué pasos
    debo seguir para conseguirlo */

}
