package servidor.microservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import servidor.microservice.App;
import servidor.microservice.model.Dados;
import servidor.microservice.model.enums.StatusIntegrador;
import servidor.microservice.service.ConsumerIntegradorService;

import java.util.List;

@RestController
@RequestMapping(App.PATH)
@Slf4j
public class ConsumerIntegrador {

    @Autowired
    private ConsumerIntegradorService consumerIntegradorService;

    @GetMapping(
            name = "consumers",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dados>> listar(@RequestParam(name = "nome", required = false) String nome,
                                              @RequestParam(name = "pedido", required = false) String pedido,
                                              @RequestParam(name = "status", required = false) String statusIntegrador) {
        try {

            var request = Dados.builder()
                    .pedido(pedido)
                    .nome(nome)

                    .build();

            if (isNotNull(statusIntegrador)) {
                request.setStatusIntegrador(StatusIntegrador.valueOf(statusIntegrador.toUpperCase()));
            }
            //TODO Pendente -> implementar consultas na services.
            var retorno = consumerIntegradorService.listarServicos(request);
            return ResponseEntity.ok(retorno);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private boolean isNotNull(String statusIntegrador) {
        return statusIntegrador != null ? true : false;
    }
}
