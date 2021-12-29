package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CompraService {

//    Sem lombok
//    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDTO compra) {
        final String estado = compra.getEndereco().getEstado();

        log.info("buscando as informações do fornecedor de {}", estado);
        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(estado);

        log.info("realizando pedido");
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());

        return new Compra(pedido.getId(), pedido.getTempoDePreparo(), compra.getEndereco().toString());
    }
}
