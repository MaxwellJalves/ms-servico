package servidor.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import servidor.microservice.model.Dados;

@Repository
public interface DadosRepository extends JpaRepository<Dados,Integer> {
}
