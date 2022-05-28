package servidor.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import servidor.microservice.model.Servicos;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos,Integer> {
}
