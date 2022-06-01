package servidor.microservice.model.enums;

import lombok.Getter;

@Getter
public enum StatusIntegrador {
    PENDENTE("Pendente"),    EM_PROCESSAMENTO("PROCESSANDO"),    CONCLUIDO("Concluido");

    private String value;

    StatusIntegrador(String value){
        this.value = value;
    }


}
