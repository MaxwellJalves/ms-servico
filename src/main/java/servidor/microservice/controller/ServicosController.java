package servidor.microservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servidor.microservice.model.dto.ServicosRequestDTO;
import servidor.microservice.model.dto.ServicosResponseDTO;
import servidor.microservice.service.ServicosImpl;

import java.net.URI;

@RestController
@RequestMapping("app/v1/servicos")
@AllArgsConstructor
@Slf4j
public class ServicosController {

    private ServicosImpl servicosImpl;

    @GetMapping
    public ResponseEntity<Object> listar(@RequestParam(name = "nome", required = false) String nome,
                                         @RequestParam(name = "codigo", required = false) Integer codigo) {
        log.info(String.format("Parametros obtidos nome : { %s } , codigo : { %d }", nome, codigo));
        //TODO Pendente -> implementar consultas na services.
        return ResponseEntity.ok(servicosImpl.listarServicos());
    }

    @PostMapping
    public ResponseEntity<ServicosResponseDTO> cadastrarServico(@RequestBody ServicosRequestDTO servicosRequestDTO) {
        var response = servicosImpl.cadastrarServicos(servicosRequestDTO);
        return ResponseEntity.created(URI.create(String.format("/servicos/%d", response.getCodigo()))).body(response);
    }

}
