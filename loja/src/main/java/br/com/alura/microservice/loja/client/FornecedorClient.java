package br.com.alura.microservice.loja.client;

import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("fornecedor")
public interface FornecedorClient {
    // vai no serviço e implementa os métodos dessa interface com q tá no serviço(no controller)

    @RequestMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);
}
