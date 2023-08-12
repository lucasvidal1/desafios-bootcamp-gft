package one.dio.labpadroesprojetospring.service;

import one.dio.labpadroesprojetospring.dto.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<ClienteDTO> buscarTodos();

    Optional<ClienteDTO> buscarPorId(Long Id);

    Optional<ClienteDTO> inserir(ClienteDTO clienteRequest);

    Optional<ClienteDTO> atualizar(Long Id, ClienteDTO clienteRequest);

    boolean deletar(Long Id);
}
