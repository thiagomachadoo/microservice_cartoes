package io.github.thiagomachadoo.microservice_cartoes.application;

import io.github.thiagomachadoo.microservice_cartoes.application.representation.CartaoSaveRequestDTO;
import io.github.thiagomachadoo.microservice_cartoes.application.representation.CartoesPorClienteResponse;
import io.github.thiagomachadoo.microservice_cartoes.application.representation.ClienteCartaoService;
import io.github.thiagomachadoo.microservice_cartoes.domain.Cartao;
import io.github.thiagomachadoo.microservice_cartoes.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("cartoes")
public class CartoesResource {

    private final CartaoService cartaoService;
    private final ClienteCartaoService cartaoServiceCliente;

    @GetMapping
    public String status(){
        return "OK!";
    }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoSaveRequestDTO request){
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda){
            List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
            return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> list = cartaoServiceCliente.listCartoesByCpf(cpf);
        List<CartoesPorClienteResponse> resultList = list.stream()
                .map(CartoesPorClienteResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }

}
