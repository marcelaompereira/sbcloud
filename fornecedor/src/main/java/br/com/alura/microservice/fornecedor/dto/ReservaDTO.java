package br.com.alura.microservice.fornecedor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {
    private Integer idReserva;
    private Integer tempoDePreparo;
}
