package servidor.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import servidor.microservice.model.Dados;
import servidor.microservice.model.enums.StatusIntegrador;
import servidor.microservice.repository.DadosRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/integrador")
public class Integrador {

    @Autowired
    private DadosRepository dadosRepository;

    @PostMapping
    public List<Dados> objectList(){
      var dados =   new ArrayList<Dados>();
      dados.add(Dados.builder().nome("max").statusIntegrador(StatusIntegrador.CONCLUIDO).pedido("2025").build());
      dados.add(Dados.builder().nome("joao").statusIntegrador(StatusIntegrador.PENDENTE).pedido("2121").build());
      dados.add(Dados.builder().nome("jose").statusIntegrador(StatusIntegrador.EM_PROCESSAMENTO).pedido("2122").build());
      dados.add(Dados.builder().nome("maria").statusIntegrador(StatusIntegrador.EM_PROCESSAMENTO).pedido("2123").build());
      dados.add(Dados.builder().nome("amadeu").statusIntegrador(StatusIntegrador.EM_PROCESSAMENTO).pedido("2123").build());
      dados.add(Dados.builder().nome("guilherme").statusIntegrador(StatusIntegrador.CONCLUIDO).pedido("2024").build());
      dados.add(Dados.builder().nome("henrique").statusIntegrador(StatusIntegrador.CONCLUIDO).pedido("2023").build());
      dados.add(Dados.builder().nome("gabriel").statusIntegrador(StatusIntegrador.CONCLUIDO).pedido("1000").build());

        return   dadosRepository.saveAll(dados);
    }



    @GetMapping
    public List<Dados> listar(){
        return dadosRepository.findAll();
    }
}
