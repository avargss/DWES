package org.iesbelen.videoclub.service;

import org.iesbelen.videoclub.domain.Pelicula;
import org.iesbelen.videoclub.exception.PeliculaNotFoundException;
import org.iesbelen.videoclub.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> all() {
        return this.peliculaRepository.findAll();
    }

    public Pelicula save(Pelicula pelicula) {
        return this.peliculaRepository.save(pelicula);
    }

    public Pelicula one(Long id) {
        return this.peliculaRepository.findById(id)
                .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    public Pelicula replace(Long id, Pelicula pelicula) {

        return this.peliculaRepository.findById(id).map(p -> (id.equals(pelicula.getIdPelicula()) ?
                        this.peliculaRepository.save(pelicula) : null))
                .orElseThrow(() -> new PeliculaNotFoundException(id));

    }

    public void delete(Long id) {
        this.peliculaRepository.findById(id).map(p -> {
                    this.peliculaRepository.delete(p);
                    return p;
                })
                .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    public List<Pelicula> findAllByOrderByTituloAsc() {
        return this.peliculaRepository.findAllByOrderByTituloAsc();
    }

    // ORDENACION CON UN SOLO PARÁMETRO
    public List<Pelicula> obtenerPeliculasOrdenadas(String orden) {

        // De esta forma, puedo ordenar las peliculas en postman con un solo parámetro orden: columna,sentido (localhost:8080/peliculas?orden=titulo,desc)
        Sort sort = Sort.unsorted();

        if (orden != null && !orden.isEmpty()) {
            // Aquí divido orden en columna y sentido
            String[] parts = orden.split(",");
            if (parts.length == 2) {
                String columna = parts[0];
                String sentido = parts[1];
                Sort.Order order = (sentido.equalsIgnoreCase("desc"))
                        ? Sort.Order.desc(columna)
                        : Sort.Order.asc(columna);
                sort = Sort.by(order);
            }
        }

        return peliculaRepository.findAll(sort);

        // De esta forma, ordeno las peliculas en postman con varios parámetros orden: columna,sentido (localhost:8080/peliculas?orden=titulo,desc&orden=duracion,asc)
        /*List<Sort.Order> ordenes = new ArrayList<>();

        // Si no se pasa ningún parámetro 'orden', no se aplica ningún orden
        if (orden != null) {
            for (String criterio : orden) {

                // Divide el parámetro 'orden' en columna y dirección
                String[] partes = criterio.split(",");
                if (partes.length == 2) {
                    String columna = partes[0];
                    String sentido = partes[1];

                    // Determinar si el orden es ascendente o descendente
                    Sort.Order order = (sentido.equalsIgnoreCase("desc"))
                            ? Sort.Order.desc(columna)
                            : Sort.Order.asc(columna);

                    ordenes.add(order);
                }
            }
        }
        // Si hay criterios de orden se crea un objeto Sort
        Sort sort = ordenes.isEmpty() ? Sort.unsorted() : Sort.by(ordenes);

        return peliculaRepository.findAll(sort);*/
    }

    // PAGINACION CON 2 PARÁMETROS
    public Map<String, Object> all(int pagina, int tamanio) {
        // Crea el objeto pageable para paginar las peliculas y ordenarlas por idPelicula
        Pageable paginado = PageRequest.of(pagina, tamanio, Sort.by("idPelicula").ascending());

        Page<Pelicula> pageAll = this.peliculaRepository.findAll(paginado);

        Map<String, Object> response = new HashMap<>();

        // Aparte del resultado de la consulta, se añaden otros datos útiles para la paginación
        response.put("peliculas", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalItems", pageAll.getTotalElements());
        response.put("totalPages", pageAll.getTotalPages());

        return response;
    }

    // PAGINACION CON 2 PARÁMETROS EN UN ARRAY
    public Map<String, Object> all(String[] paginacion) {
        // Crea el objeto pageable para paginar las peliculas y ordenarlas por idPelicula
        Pageable paginado = PageRequest.of(Integer.parseInt(paginacion[0], 10), Integer.parseInt(paginacion[1], 10), Sort.by("idPelicula").ascending());

        Page<Pelicula> pageAll = this.peliculaRepository.findAll(paginado);

        Map<String, Object> response = new HashMap<>();

        // Aparte del resultado de la consulta, se añaden otros datos útiles para la paginación
        response.put("peliculas", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalItems", pageAll.getTotalElements());
        response.put("totalPages", pageAll.getTotalPages());

        return response;
    }

}
