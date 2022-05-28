package servidor.microservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import servidor.microservice.model.Servicos;
import servidor.microservice.model.dto.ServicosRequestDTO;
import servidor.microservice.model.dto.ServicosResponseDTO;
import servidor.microservice.repository.ServicosRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicosImpl {

    ObjectMapper objectMapper = new ObjectMapper();
    private ServicosRepository servicosRepository;


    public List<Servicos> listarServicos() {
        var response =  servicosRepository.findAll();
        return response;
    }

    public ServicosResponseDTO cadastrarServicos(ServicosRequestDTO servicosRequestDTO) {


        var response = servicosRepository.save(Servicos.builder()
                .descricao(servicosRequestDTO.getDescricao())
                .nome(servicosRequestDTO.getNome())
                .build());

        return ServicosResponseDTO.builder()
                .codigo(response.getCodigo())
                .descricao(response.getDescricao())
                .nome(response.getNome())
                .build();

    }

}
