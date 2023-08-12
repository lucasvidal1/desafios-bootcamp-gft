package one.dio.labpadroesprojetospring.repository;

import one.dio.labpadroesprojetospring.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String>{

}
