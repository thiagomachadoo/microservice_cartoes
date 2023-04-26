package io.github.thiagomachadoo.microservice_cartoes.application.representation;

import io.github.thiagomachadoo.microservice_cartoes.domain.Bandeira;
import io.github.thiagomachadoo.microservice_cartoes.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequestDTO {
    private java.lang.String nome;
    private Bandeira bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limite);
    }
}
