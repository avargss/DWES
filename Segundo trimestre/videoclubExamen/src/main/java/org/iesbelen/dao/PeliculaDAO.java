package org.iesbelen.dao;

import org.iesbelen.domain.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaDAO {

    public List<Pelicula> getAll();

    public Optional<Pelicula> find(int id_pelicula);

    public void create(Pelicula pelicula);

    public int countPelicula();
}
