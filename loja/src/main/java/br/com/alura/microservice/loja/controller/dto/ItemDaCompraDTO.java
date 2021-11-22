package br.com.alura.microservice.loja.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDaCompraDTO {

    private long id;
    private int quantidade;

}
