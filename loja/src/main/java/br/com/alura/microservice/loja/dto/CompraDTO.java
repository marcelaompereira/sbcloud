package br.com.alura.microservice.loja.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {

    private List<ItemDaCompraDTO> itens = new ArrayList<>();
    private EnderecoDTO endereco;

}
