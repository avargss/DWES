package org.iesbelen.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.domain.Categoria;
import org.iesbelen.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Categoria> getAll() {

        List<Categoria> listCat = jdbcTemplate.query(
                "SELECT * FROM categoria",
                (rs, rowNum) -> new Categoria
                        (rs.getInt("id_categoria"),
                                rs.getString("nombre")
                        )
        );

        log.info("Lista de categorias: {}", listCat);
        return listCat;

    }

    @Override
    public Optional<Categoria> find(int id_categoria) {

        Categoria cat = jdbcTemplate
                .queryForObject("SELECT * FROM categoria WHERE id_categoria = ?",
                        (rs, rowNum) -> new Categoria(rs.getInt("id_categoria"),
                                rs.getString("nombre")
                        ), id_categoria
                );

        if (cat != null) {
            return Optional.of(cat);
        } else {
            log.info("Categoria no encontrado.");
            return Optional.empty();
        }
    }
}
