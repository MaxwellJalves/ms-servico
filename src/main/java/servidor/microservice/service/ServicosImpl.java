package servidor.microservice.service;

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

    private ServicosRepository servicosRepository;


    public List<Servicos> listarServicos() {
        return servicosRepository.findAll();

    }

    public ServicosResponseDTO cadastrarServicos(ServicosRequestDTO servicosRequestDTO) {
        try {
            var response = servicosRepository.save(Servicos.builder()
                    .descricao(servicosRequestDTO.getDescricao())
                    .nome(servicosRequestDTO.getNome())
                    .build());

            return ServicosResponseDTO.convertToServicosResponseDTO(response);
        } catch (Exception e) {
            //TODO pendente : Implementar Excepions especificar com retorno do status code correspondente ao erro
            throw new IllegalArgumentException("Ops! O resgistro não pode ser salvo nesse momento , reveja os dados informados e tente novamente.");
        }

    }

}
