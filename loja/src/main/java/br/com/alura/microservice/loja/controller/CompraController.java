package br.com.alura.microservice.loja.controller;

import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.model.Compra;
import br.com.alura.microservice.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    CompraService compraService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Compra> realizaCompra(@RequestBody CompraDTO compra) {
        Compra compraRealizada = compraService.realizaCompra(compra);
        return ResponseEntity.status(HttpStatus.CREATED).body(compraRealizada);
    }
}
