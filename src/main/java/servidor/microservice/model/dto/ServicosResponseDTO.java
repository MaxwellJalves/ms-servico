package servidor.microservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicosResponseDTO {

    @JsonProperty("Codigo")
    private Integer codigo;

    @JsonProperty("Nome")
    private String nome;

    @JsonProperty("Descricao")
    private String descricao;

}
