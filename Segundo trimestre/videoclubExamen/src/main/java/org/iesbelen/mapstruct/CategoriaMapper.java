package org.iesbelen.mapstruct;

import org.iesbelen.domain.Pelicula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(target = "titulo", source = "titulo")
    public Pelicula nombreDTOAnombre(Pelicula pelicula);
}
