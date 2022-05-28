package servidor.microservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import servidor.microservice.model.Servicos;

@Data
@Builder
public class ServicosResponseDTO {

    @JsonProperty("Codigo")
    private Integer codigo;

    @JsonProperty("Nome")
    private String nome;

    @JsonProperty("Descricao")
    private String descricao;

    public static ServicosResponseDTO convertToServicosResponseDTO(Servicos servicos) {
        return ServicosResponseDTO.builder()
                .codigo(servicos.getCodigo())
                .descricao(servicos.getDescricao())
                .nome(servicos.getNome())
                .build();
    }

}
