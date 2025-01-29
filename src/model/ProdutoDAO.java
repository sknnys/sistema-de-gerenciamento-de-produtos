package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDAO {

    private List<Produto> produtos;

    // Construtor inicializa a lista de produtos
    public ProdutoDAO() {
        this.produtos = new ArrayList<>();
    }

    // Adiciona um novo produto à lista
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Busca um produto pelo nome (caso insensível)
    public Optional<Produto> buscarProduto(String nome) {
        return produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
       

    // Remove um produto da lista, se encontrado pelo nome
    public boolean removerProduto(String nome) {
        return buscarProduto(nome)
                .map(produto -> produtos.remove(produto))
                .orElse(false);
    }

    // Retorna uma lista de produtos, podendo ser ordenada por nome
    public List<Produto> listarProdutos(boolean ordenados) {
        if (ordenados) {
            produtos.sort(Produto::compareTo);
        }
        return new ArrayList<>(produtos); // Retorna uma cópia da lista para evitar modificações externas
    }
}
