package br.com.alura.microservice.loja.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoPedidoDTO {
    private Long id;
    private Integer tempoDePreparo;
}
