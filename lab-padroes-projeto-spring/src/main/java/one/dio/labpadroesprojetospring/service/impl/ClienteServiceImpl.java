package one.dio.labpadroesprojetospring.service.impl;

import one.dio.labpadroesprojetospring.dto.ClienteDTO;
import one.dio.labpadroesprojetospring.model.Cliente;
import one.dio.labpadroesprojetospring.model.Endereco;
import one.dio.labpadroesprojetospring.repository.ClienteRepository;
import one.dio.labpadroesprojetospring.repository.EnderecoRepository;
import one.dio.labpadroesprojetospring.service.ClienteService;
import one.dio.labpadroesprojetospring.service.ViaCepService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<ClienteDTO> buscarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> responses = new ArrayList<>();

        clientes.forEach(cliente -> {
            ClienteDTO response = mapper.map(cliente, ClienteDTO.class);
            responses.add(response);
        });

        return responses;
    }

    @Override
    public Optional<ClienteDTO> buscarPorId(Long Id) {
        Optional<Cliente> cliente = clienteRepository.findById(Id);
        return cliente.map(value -> mapper.map(value, ClienteDTO.class));
    }

    @Override
    public Optional<ClienteDTO> inserir(ClienteDTO clienteRequest) {
        return Optional.of(salvarClienteComCep(clienteRequest));
    }

    @Override
    public Optional<ClienteDTO> atualizar(Long Id, ClienteDTO clienteRequest) {
        Optional<Cliente> cliente = clienteRepository.findById(Id);
        if (cliente.isPresent()) {
            clienteRequest.setId(Id);
            return Optional.of(salvarClienteComCep(clienteRequest));
        }

        return Optional.empty();
    }

    @Override
    public boolean deletar(Long Id) {
        Optional<Cliente> cliente = clienteRepository.findById(Id);
        if (cliente.isPresent()) {
            clienteRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    private ClienteDTO salvarClienteComCep(ClienteDTO clienteDTO) {
        String cep = clienteDTO.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        clienteDTO.setEndereco(endereco);
        Cliente cliente = mapper.map(clienteDTO, Cliente.class);

        return mapper.map(clienteRepository.save(cliente), ClienteDTO.class);
    }
}
