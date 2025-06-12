package github.nettopro.rpgenzo.entidade.tipo;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoMapper {

    Tipo toTipo(TipoRequest tipoRequest);

    TipoRequest toTipoRequest(Tipo tipo);

}
