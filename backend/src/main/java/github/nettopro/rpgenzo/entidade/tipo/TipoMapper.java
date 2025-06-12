package github.nettopro.rpgenzo.entidade.tipo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TipoMapper {

    Tipo toTipo(TipoRequest tipoRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "acoes", ignore = true)
    void updateTipoFromRequest(TipoRequest tipoRequest, @MappingTarget Tipo tipo);
}
