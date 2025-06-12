package github.nettopro.rpgenzo.tipo;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoMapper {

    Tipo toTipo(TipoRequest tipoRequest);

    TipoRequest toTipoRequest(Tipo tipo);

    Tipo toTipo(TipoResponse tipoResponse);

    TipoResponse toTipoResponse(Tipo tipo);

}
