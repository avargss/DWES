package org.iesbelen.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class PeliculaDAOImpl implements PeliculaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Pelicula> getAll() {

        List<Pelicula> listPel = jdbcTemplate.query(
                "SELECT * FROM pelicula ORDER BY id_pelicula DESC",
                (rs, rowNum) -> new Pelicula(
                        rs.getInt("id_pelicula"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getInt("anyo_lanzamiento"),
                        rs.getInt("id_idioma"),
                        rs.getInt("duracion")
                )
        );

        log.info("Lista de peliculas: {}", listPel);
        return listPel;

    }

    @Override
    public Optional<Pelicula> find(int id_pelicula) {

        Pelicula pel = jdbcTemplate
                .queryForObject("SELECT * FROM pelicula WHERE id_pelicula = ?",
                        (rs, rowNum) -> new Pelicula(
                                rs.getInt("id_pelicula"),
                                rs.getString("titulo"),
                                rs.getString("descripcion"),
                                rs.getInt("anyo_lanzamiento"),
                                rs.getInt("id_idioma"),
                                rs.getInt("duracion")
                        ), id_pelicula
                );

        if (pel != null) {
            return Optional.of(pel);
        } else {
            log.info("Pelicula no encontrado.");
            return Optional.empty();
        }
    }

    @Override
    public synchronized void create(Pelicula pelicula) {

        jdbcTemplate.update("INSERT INTO pelicula (id_pelicula, titulo, descripcion, anyo_lanzamiento, id_idioma, duracion) VALUES (?, ?, ?, ?, ?, ?)", pelicula.getId_pelicula(), pelicula.getTitulo(), pelicula.getDescripcion(), pelicula.getAnyo_lanzamiento(), pelicula.getId_idioma(), pelicula.getDuracion());

    }

    @Override
    public int countPelicula() {

        int contarPeliculas = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM pelicula_categoria WHERE id_categoria = ?", Integer.class);

        log.info("Lista de peliculas: {}", contarPeliculas);
        return contarPeliculas;

    }



}
