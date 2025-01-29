package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe que representa um produto do tipo alimento.
 */
public class ProdutoAlimento extends Produto {

    private LocalDate dataValidade;

    // Construtor para criar um produto de alimento.
    public ProdutoAlimento(String nome, double preco, int quantidadeEmEstoque, LocalDate dataValidade) {
        super(nome, preco, quantidadeEmEstoque);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    //Retorna detalhes específicos do produto,data de validade.
    @Override
    public String getDetalhes() {
        return "Data de Validade: " + dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    //Retorna uma representação textual do produto de alimento.
    @Override
    public String toString() {
        return String.format("Produto Alimento - Nome: %s, Preço: R$ %.2f, Quantidade em Estoque: %d, Data de Validade: %s",
                getNome(), getPreco(), getQuantidadeEmEstoque(), dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
