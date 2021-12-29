package br.com.alura.microservice.fornecedor.service;

import br.com.alura.microservice.fornecedor.dto.ItemDoPedidoDTO;
import br.com.alura.microservice.fornecedor.model.Pedido;
import br.com.alura.microservice.fornecedor.model.PedidoItem;
import br.com.alura.microservice.fornecedor.model.Produto;
import br.com.alura.microservice.fornecedor.repository.PedidoRepository;
import br.com.alura.microservice.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {
        if(itens == null) {
            return null;
        }

        List<PedidoItem> pedidoItems = toPedidoItem(itens);
        Pedido pedido = new Pedido(pedidoItems);
        pedido.setTempoDePreparo(itens.size());
        return pedidoRepository.save(pedido);
    }

    public Pedido getPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(new Pedido());
    }

    private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {
        List<Long> idProdutos = itens.stream().map(item -> item.getId()).collect(Collectors.toList());

        List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idProdutos);

        List<PedidoItem> pedidoItems = itens.stream().map(item -> {
            Produto produto = produtosDoPedido.stream().filter(p -> p.getId() == item.getId()).findFirst().get();
            PedidoItem pedidoItem = new PedidoItem();
            pedidoItem.setProduto(produto);
            pedidoItem.setQuantidade(item.getQuantidade());
            return pedidoItem;
        }).collect(Collectors.toList());
        return pedidoItems;
    }
}
