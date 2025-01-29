package controller;

import model.Produto;
import model.ProdutoAlimento;
import model.ProdutoEletronico;
import model.ProdutoDAO;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProdutoController {

    private final ProdutoDAO produtoDAO;

    // Construtor do controlador de produto
    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
    }

    // Adiciona um novo produto baseado no tipo e atributos fornecidos
    public void adicionarProduto(String tipo, String nome, String precoStr, String quantidadeStr,
            String marca, String modelo, String dataValidade) {

        Produto novoProduto = criarProduto(tipo, nome, precoStr, quantidadeStr, marca, modelo, dataValidade);
        produtoDAO.adicionarProduto(novoProduto);
    }

    // Cria o produto apropriado com base no tipo (Eletrônico ou Alimento)
    private Produto criarProduto(String tipo, String nome, String precoStr, String quantidadeStr,
            String marca, String modelo, String dataValidade) {
        double preco = validarPreco(precoStr);
        int quantidade = validarQuantidade(quantidadeStr);
        validarInput(nome, "Nome do Produto");

        switch (tipo) {
            case "Eletrônico":
                return criarProdutoEletronico(nome, preco, quantidade, marca, modelo);
            case "Alimento":
                LocalDate validade = validarDataValidade(dataValidade);
                return new ProdutoAlimento(nome, preco, quantidade, validade);
            default:
                throw new IllegalArgumentException("Tipo de produto inválido. Deve ser 'Eletrônico' ou 'Alimento'.");
        }
    }

    // Criação de produto eletrônico com validação de marca e modelo
    private ProdutoEletronico criarProdutoEletronico(String nome, double preco, int quantidade,
            String marca, String modelo) {
        validarInput(marca, "Marca do Produto");
        validarInput(modelo, "Modelo do Produto");
        return new ProdutoEletronico(nome, preco, quantidade, marca, modelo);
    }

    // Valida campos de entrada de texto (nome, marca, modelo)
    private void validarInput(String input, String campo) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " não pode estar vazio.");
        }
        if (!input.matches("^[a-zA-ZÀ-ÿ0-9\\s]+$")) {
            throw new IllegalArgumentException(campo + " contém caracteres inválidos. Use apenas letras e números");
        }
    }

    // Valida o preço
    private double validarPreco(String precoStr) {
        try {
            double preco = Double.parseDouble(precoStr);
            if (preco < 0) {
                throw new IllegalArgumentException("O preço não pode ser negativo.");
            }
            return preco;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Preço inválido.");
        }
    }

    // Valida a quantidade em estoque
    private int validarQuantidade(String quantidadeStr) {
        try {
            int quantidade = Integer.parseInt(quantidadeStr);
            if (quantidade < 0) {
                throw new IllegalArgumentException("A quantidade não pode ser negativa.");
            }
            return quantidade;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }
    }

    // Valida a data de validade para produtos do tipo alimento
    private LocalDate validarDataValidade(String dataValidadeStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dataValidadeStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data de validade inválida! Use o formato dd/MM/yyyy.");
        }
    }

    // Remove um produto pelo nome
    public boolean removerProduto(String nome) {
        return produtoDAO.removerProduto(nome);
    }

    // Busca um produto pelo nome
    public Produto buscarProduto(String nome) {
        return produtoDAO.buscarProduto(nome).orElse(null);
    }

    // Pesquisa produtos por vários critérios (nome, marca, modelo, quantidade)
    public Set<Produto> pesquisarProdutos(String nome, String marca, String modelo, String quantidadeStr) {
        Set<Produto> resultados = new HashSet<>();

        // Pesquisa produto pelo nome
        if (!nome.isEmpty()) {
            Produto produto = buscarProduto(nome);
            if (produto != null) {
                resultados.add(produto);
            }
        }

        // Pesquisa produtos eletrônicos por marca ou modelo
        for (Produto p : produtoDAO.listarProdutos(false)) {
            if (p instanceof ProdutoEletronico) {
                ProdutoEletronico eletronico = (ProdutoEletronico) p;

                boolean marcaMatch = !marca.isEmpty() && eletronico.getMarca().equalsIgnoreCase(marca);
                boolean modeloMatch = !modelo.isEmpty() && eletronico.getModelo().equalsIgnoreCase(modelo);

                if (marcaMatch || modeloMatch) {
                    resultados.add(p);
                }
            }
        }

        // Pesquisa produtos pela quantidade
        if (!quantidadeStr.isEmpty()) {
            try {
                int quantidade = Integer.parseInt(quantidadeStr);
                for (Produto p : produtoDAO.listarProdutos(false)) {
                    if (p.getQuantidadeEmEstoque() == quantidade) {
                        resultados.add(p);
                    }
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Quantidade deve ser um número.");
            }
        }

        return resultados;
    }

    // Edita um produto existente
    public boolean editarProduto(Produto produto, String novoNome, double novoPreco, int novaQtd) {
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            validarInput(novoNome, "Nome do Produto");
            produto.setNome(novoNome);
        }
        produto.setPreco(novoPreco);
        produto.setQuantidadeEmEstoque(novaQtd);

        // Edita atributos específicos se o produto for do tipo Eletrônico ou Alimento
        if (produto instanceof ProdutoEletronico) {
            return editarProdutoEletronico((ProdutoEletronico) produto);
        } else if (produto instanceof ProdutoAlimento) {
            return editarProdutoAlimento((ProdutoAlimento) produto);
        }

        return true;
    }

    // Edita os atributos de um produto eletrônico
    public boolean editarProdutoEletronico(ProdutoEletronico produto) {
        String novaMarca = JOptionPane.showInputDialog("Insira a Nova Marca:", produto.getMarca());
        if (novaMarca != null && !novaMarca.trim().isEmpty()) {
            validarInput(novaMarca, "Marca do Produto");
            produto.setMarca(novaMarca);
        }

        String novoModelo = JOptionPane.showInputDialog("Insira um Novo Modelo:", produto.getModelo());
        if (novoModelo != null && !novoModelo.trim().isEmpty()) {
            validarInput(novoModelo, "Modelo do Produto");
            produto.setModelo(novoModelo);
        }

        return true;
    }

    // Edita os atributos de um produto do tipo alimento
    public boolean editarProdutoAlimento(ProdutoAlimento produto) {
        String novaDataValidade = JOptionPane.showInputDialog("Nova Data de Validade (dd/MM/yyyy):",
                produto.getDataValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        if (novaDataValidade != null && !novaDataValidade.trim().isEmpty()) {
            try {
                LocalDate validade = LocalDate.parse(novaDataValidade, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                produto.setDataValidade(validade);
                return true;
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Data de validade inválida! Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }

    // Lista produtos (ordenados ou não, com ou sem embaralhamento)
    public String listarProdutos(boolean ordenados, boolean embaralhar) {
        StringBuilder sb = new StringBuilder();
        List<Produto> listaProdutos = produtoDAO.listarProdutos(ordenados);

        if (embaralhar) {
            Collections.shuffle(listaProdutos);
        }

        if (listaProdutos.isEmpty()) {
            return "Nenhum produto cadastrado, cadastre seu produto favorito.";
        }

        for (Produto produto : listaProdutos) {
            sb.append(produto).append("\n");
        }

        return sb.toString();
    }
}
