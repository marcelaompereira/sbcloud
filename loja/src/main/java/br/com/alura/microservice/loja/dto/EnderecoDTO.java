package br.com.alura.microservice.loja.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnderecoDTO {

    private String rua;
    private int numero;
    private String estado;

}
