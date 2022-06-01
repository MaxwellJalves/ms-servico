package servidor.microservice.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import servidor.microservice.App;
import servidor.microservice.model.Dados;
import servidor.microservice.utils.Validation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
@NoArgsConstructor
@Slf4j
public class ConsumerIntegradorService {


    RestTemplate restTemplate = new RestTemplate();

    public List<Dados> listarServicos(Dados request) throws IOException {


        var responseApi = consumerApi();

        if (Validation.isNotNull(request.getNome())) {
            log.info("NOME OBTIDO:::: " + request.getNome());
            return responseApi
                    .filter(f -> f.getNome()
                            .toLowerCase().contains(request.getNome()))
                    .collect(Collectors.toList());

        }

        if (Validation.isNotNull(request.getStatusIntegrador())) {
            var status = request.getStatusIntegrador().name();

            var list = responseApi.filter(f -> f.getStatusIntegrador().name().contains(status.toUpperCase()))
                    .collect(Collectors.toList());

            if (list.size() > 0) {
                return list;
            }

            return new ArrayList<>();
        }

        if (Validation.isNotNull(request.getPedido())) {
            return responseApi.filter(f -> f.getPedido().contains(request.getPedido()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private Stream<Dados> consumerApi() {

        var retorno = restTemplate.getForEntity(App.BASE_URL, Dados[].class);
        return Arrays.stream(retorno.getBody());
    }


}
