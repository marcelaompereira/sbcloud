package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    RestTemplate client;

    public void realizaCompra(CompraDTO compra) {
        ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
                "http://fornecedor/info/" + compra.getEndereco().getEstado(),
                HttpMethod.GET,
                null,
                InfoFornecedorDTO.class
        );

        System.out.println(exchange.getBody());
    }
}
