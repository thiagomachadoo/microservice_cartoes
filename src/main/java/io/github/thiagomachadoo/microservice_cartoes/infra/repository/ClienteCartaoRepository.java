package io.github.thiagomachadoo.microservice_cartoes.infra.repository;

import io.github.thiagomachadoo.microservice_cartoes.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {

    List<ClienteCartao> findByCpf(String cpf);
}
