package io.github.thiagomachadoo.microservice_cartoes.application.representation;

import io.github.thiagomachadoo.microservice_cartoes.domain.ClienteCartao;
import io.github.thiagomachadoo.microservice_cartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {
    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
