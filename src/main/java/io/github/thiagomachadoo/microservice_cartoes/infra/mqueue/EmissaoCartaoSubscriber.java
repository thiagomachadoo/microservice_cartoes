package io.github.thiagomachadoo.microservice_cartoes.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.thiagomachadoo.microservice_cartoes.domain.Cartao;
import io.github.thiagomachadoo.microservice_cartoes.domain.ClienteCartao;
import io.github.thiagomachadoo.microservice_cartoes.domain.DadosDeSolicitacaoEmissaoCartao;
import io.github.thiagomachadoo.microservice_cartoes.infra.repository.CartaoRepository;
import io.github.thiagomachadoo.microservice_cartoes.infra.repository.ClienteCartaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoRepository cartao;
    private final ClienteCartaoRepository clienteCartaoRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload) throws JsonProcessingException {

        var mapper = new ObjectMapper();
        DadosDeSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosDeSolicitacaoEmissaoCartao.class);
        Cartao cartao_cliente = cartao.findById(dados.getIdCartao()).orElseThrow();
        ClienteCartao clienteCartao = new ClienteCartao();
        clienteCartao.setCartao(cartao_cliente);
        clienteCartao.setCpf(dados.getCpf());
        clienteCartao.setLimite(dados.getLimiteLiberado());

        clienteCartaoRepository.save(clienteCartao);
    }

}
