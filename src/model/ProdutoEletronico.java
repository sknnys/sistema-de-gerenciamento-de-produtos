package model;

public class ProdutoEletronico extends Produto {

    private String marca;
    private String modelo;

    // Construtor da classe ProdutoEletronico
    public ProdutoEletronico(String nome, double preco, int quantidadeEmEstoque, String marca, String modelo) {
        super(nome, preco, quantidadeEmEstoque);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String getDetalhes() {
        return String.format("Marca: %s, Modelo: %s", marca, modelo);
    }

    @Override
    public String toString() {
        return String.format("Produto Eletrônico - Nome: %s, Preço: R$ %.2f, Quantidade: %d, Marca: %s, Modelo: %s",
                nome, preco, quantidadeEmEstoque, marca, modelo);
    }
}
