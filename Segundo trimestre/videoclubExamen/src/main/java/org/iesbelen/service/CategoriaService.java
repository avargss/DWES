package org.iesbelen.service;

import org.iesbelen.dao.CategoriaDAO;
import org.iesbelen.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaDAO categoriaDAO;

    public CategoriaService(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    public List<Categoria> listAll() {
        return categoriaDAO.getAll();
    }

    public Categoria one(int id) {

        Optional<Categoria> optCat = categoriaDAO.find(id);
        if (optCat.isPresent()) {
            return optCat.get();
        } else {
            return null;
        }
    }


}
