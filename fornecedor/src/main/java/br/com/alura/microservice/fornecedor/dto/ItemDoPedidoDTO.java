package br.com.alura.microservice.fornecedor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDoPedidoDTO {
    private long id;
    private int quantidade;
}
