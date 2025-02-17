package org.iesbelen.service;

import org.iesbelen.dao.CategoriaDAO;
import org.iesbelen.dao.PeliculaDAO;
import org.iesbelen.domain.Categoria;
import org.iesbelen.domain.Pelicula;
import org.iesbelen.dto.PeliculaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaDAO peliculaDAO;

    @Autowired
    private CategoriaDAO categoriaDAO;

    public PeliculaService(PeliculaDAO peliculaDAO) {
        this.peliculaDAO = peliculaDAO;
    }

    public List<Pelicula> listAll() {
        return peliculaDAO.getAll();
    }

    public Pelicula one(int id) {

        Optional<Pelicula> optPel = peliculaDAO.find(id);
        if (optPel.isPresent()) {
            return optPel.get();
        } else {
            return null;
        }
    }

    /*public List<PeliculaDTO> listPeliculaDTO(int id_categoria) {

        List<Categoria> categorias = categoriaDAO.getAll();
        List<Pelicula> peliculas = peliculaDAO.getCategoriaByID(id_categoria);
        peliculas.sort((p1, p2) -> p1.getTitulo().compareToIgnoreCase(p2.getTitulo()));

        List<PeliculaDTO> peliculasDTO = new ArrayList<>();

        for (Pelicula pelicula : peliculas) {
            int idP = pelicula.get();
            for (Categoria categoria : categorias) {
                if (categoria.getId_categoria() == idP) {

                }
            }
        }

        return null;
    }*/

    public void newPelicula(Pelicula pelicula) {
        peliculaDAO.create(pelicula);
    }
}
