package io.github.thiagomachadoo.microservice_cartoes.application.representation;

import io.github.thiagomachadoo.microservice_cartoes.domain.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartoesPorClienteResponse {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static CartoesPorClienteResponse fromModel(ClienteCartao model){
        return new CartoesPorClienteResponse( model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getLimite());

    }

}
