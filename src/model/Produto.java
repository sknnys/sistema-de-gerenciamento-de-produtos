package model;

// Classe abstrata que define um Produto base
public abstract class Produto implements Comparable<Produto> {

    protected String nome;
    protected double preco;
    protected int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public int compareTo(Produto outroProduto) {
        // Comparação de produtos pelo nome
        return this.nome.compareTo(outroProduto.getNome());
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Preço: R$ %.2f, Quantidade: %d", nome, preco, quantidadeEmEstoque);
    }

    // Método abstrato que deve ser implementado pelas subclasses
    public abstract String getDetalhes();
}
