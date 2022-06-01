package servidor.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import servidor.microservice.model.enums.StatusIntegrador;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dados {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome",nullable = true)
    private String nome;

    @Enumerated(value = EnumType.STRING)
    private StatusIntegrador statusIntegrador;

    @Column(name = "pedido",nullable = true)
    private String pedido;
}
