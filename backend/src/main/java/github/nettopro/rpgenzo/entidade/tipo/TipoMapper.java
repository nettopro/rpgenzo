package github.nettopro.rpgenzo.entidade.tipo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import github.nettopro.rpgenzo.entidade.tipo.dto.TipoRequest;
import github.nettopro.rpgenzo.entidade.tipo.dto.TipoResponse;

@Mapper(componentModel = "spring")
public interface TipoMapper {

    @Mapping(target = "acoes", ignore = true)
    Tipo toTipo(TipoRequest tipoRequest);

    @Mapping(target = "grupo", source = "grupo.descricao")
    TipoResponse toTipoResponse(Tipo tipo);

    @Mapping(target = "acoes", ignore = true)
    void updateTipoFromRequest(TipoRequest tipoRequest, @MappingTarget Tipo tipo);
}
