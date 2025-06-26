package github.nettopro.rpgenzo.entidade.tipo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TipoMapper {

    @Mapping(target = "acoes", ignore = true)
    Tipo toTipo(TipoRequest tipoRequest);

    @Mapping(target = "acoes", ignore = true)
    void updateTipoFromRequest(TipoRequest tipoRequest, @MappingTarget Tipo tipo);
    //Todo: Remover responses do Mapper e usar Projections diretamente no Service
    TipoResponse toTipoResponse(Tipo tipo);
}
