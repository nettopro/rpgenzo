package github.nettopro.rpgenzo.entidade.acao;

import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import github.nettopro.rpgenzo.entidade.acao.dto.AcaoRequest;
import github.nettopro.rpgenzo.entidade.acao.dto.AcaoSemTipoResponse;
import github.nettopro.rpgenzo.entidade.exception.EntidadeNotFoundException;
import github.nettopro.rpgenzo.entidade.tipo.Tipo;
import github.nettopro.rpgenzo.entidade.tipo.TipoRepository;

@Mapper(componentModel = "spring")
public abstract class AcaoMapper {

    @Autowired
    protected TipoRepository tipoRepository;

    @Mapping(target = "acaoTipos", source = "acaoTiposIds", qualifiedByName = "mapTipoIdsToTipos")
    @Mapping(target = "acaoCusto", defaultValue = "0")
    @Mapping(target = "acaoLivreCusto", defaultValue = "0")
    @Mapping(target = "reacaoAcionamento", defaultValue = "")
    @Mapping(target = "requerimento", defaultValue = "")
    public abstract Acao toAcao(AcaoRequest acaoRequest);

    @Named("mapTipoIdsToTipos")
    protected Set<Tipo> mapTipoIdsToTipos(Set<Integer> tipoIds) {
        if (tipoIds == null || tipoIds.isEmpty()) {
            return Set.of();
        }
        return tipoIds.stream()
                .map(id -> tipoRepository.findById(id)
                        .orElseThrow(() -> new EntidadeNotFoundException("Tipo com ID " + id + " não encontrado.")))
                .collect(Collectors.toSet());
    }

    @Mapping(target = "acaoTipos", source = "acaoTiposIds", qualifiedByName = "mapTipoIdsToTipos")
    @Mapping(target = "acaoCusto", defaultValue = "0")
    @Mapping(target = "acaoLivreCusto", defaultValue = "0")
    @Mapping(target = "reacaoAcionamento", defaultValue = "")
    @Mapping(target = "requerimento", defaultValue = "")
    public abstract void updateAcaoFromRequest(AcaoRequest acaoRequest, @MappingTarget Acao acao);

    public abstract AcaoSemTipoResponse toAcaoSemTipoResponse(Acao acao);
}
