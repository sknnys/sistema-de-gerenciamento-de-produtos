package view;

import controller.ProdutoController;
import model.Produto;

import javax.swing.*;
import java.util.Set;

public class ProdutoView extends javax.swing.JFrame {

    ProdutoController controller = new ProdutoController(); //Instancia o controlador de produtos

    public ProdutoView() {
        initComponents(); // Inicializa os componentes da interface gráfica
        jComboBox.setSelectedItem("Eletrônico"); // Define o tipo padrão como "Eletrônico"
        atualizarVisibilidadeCampos(); // Atualiza a visibilidade dos campos com base no tipo selecionado
    }

    private void limparCampos() {
        // Limpa os campos de entrada de dados
        jTextNome.setText("");
        jTextPreco.setText("");
        jTextQtd.setText("");
        jTextMarca.setText("");
        jTextModelo.setText("");
        jTextValidade.setText("");
    }

    private void atualizarListaProdutos() {
        String produtos = controller.listarProdutos(false, true); // Chama o método para listar produtos
        jTextLista.setText(produtos); // Atualiza o JTextArea ou outro componente que exibe a lista
    }

    private void atualizarVisibilidadeCampos() {
        String tipo = (String) jComboBox.getSelectedItem(); // Obtém o tipo de produto selecionado
        boolean isAlimento = tipo.equals("Alimento"); // Verifica se o tipo é "Alimento"

        // Define a visibilidade dos campos com base no tipo de produto
        jTextMarca.setVisible(!isAlimento); // Oculta campo de marca se for alimento
        jTextModelo.setVisible(!isAlimento); // Oculta campo de modelo se for alimento
        jTextValidade.setVisible(isAlimento); // Mostra campo de validade se for alimento
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextModelo = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jTextValidade = new javax.swing.JTextField();
        jButtonListarOR = new javax.swing.JButton();
        jTextNome = new javax.swing.JTextField();
        jButtonListarNOR = new javax.swing.JButton();
        jComboBox = new javax.swing.JComboBox<>();
        jTextPreco = new javax.swing.JTextField();
        jLabelTipo = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelPreco = new javax.swing.JLabel();
        jLabelQtd = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jTextQtd = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jLabelValidade = new javax.swing.JLabel();
        jTextMarca = new javax.swing.JTextField();
        jButtonRemove = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTextLista = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextModeloActionPerformed(evt);
            }
        });
        getContentPane().add(jTextModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 300, 20));

        jButtonEdit.setText("Editar Produto");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 190, 140, -1));

        jTextValidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextValidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextValidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 300, 20));

        jButtonListarOR.setText("Listar Produtos Ordenados");
        jButtonListarOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarORActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonListarOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 220, 240, -1));

        jTextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 300, 20));

        jButtonListarNOR.setText("Listar Produtos Não Ordenados");
        jButtonListarNOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarNORActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonListarNOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 240, -1));

        jComboBox.setMaximumRowCount(2);
        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alimento", "Eletrônico" }));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 300, 30));

        jTextPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrecoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 300, 20));

        jLabelTipo.setText("Tipo de Produto:");
        getContentPane().add(jLabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 20));

        jLabelNome.setText("Nome:");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 220, 10));

        jLabelPreco.setText("Preço:");
        getContentPane().add(jLabelPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 230, -1));

        jLabelQtd.setText("Quantidade:");
        getContentPane().add(jLabelQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, -1));

        jLabelMarca.setText("Marca (para Eletrônico):");
        getContentPane().add(jLabelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, -1));

        jLabelModelo.setText("Modelo (para Eletrônicos):");
        getContentPane().add(jLabelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 118, -1, 20));

        jButtonSearch.setText("Pesquisar 🔎 ");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, 20));

        jTextQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextQtdActionPerformed(evt);
            }
        });
        getContentPane().add(jTextQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 300, 20));

        jButtonAdd.setText("Adicionar Produto");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 190, 170, -1));

        jLabelValidade.setText("Data de Validade(para Alimentos):");
        getContentPane().add(jLabelValidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jTextMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 300, 20));

        jButtonRemove.setText("Remover Produto");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 140, -1));

        jTextLista.setColumns(20);
        jTextLista.setRows(5);
        jScrollPane.setViewportView(jTextLista);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 580, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonListarORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarORActionPerformed
        String produtos = controller.listarProdutos(true, false); // Lista os produtos ordenados
        if (produtos.isEmpty()) { // Verifica se a lista de produtos está vazia
            JOptionPane.showMessageDialog(this, "Nenhum produto cadastrado!", "Informação", JOptionPane.INFORMATION_MESSAGE); // Informa que não há produtos
        } else {
            jTextLista.setText(produtos); // Exibe a lista de produtos na interface
        }

    }//GEN-LAST:event_jButtonListarORActionPerformed

    private void jTextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeActionPerformed

    }//GEN-LAST:event_jTextNomeActionPerformed

    private void jButtonListarNORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarNORActionPerformed
        String produtos = controller.listarProdutos(false, true); // Lista os produtos sem ordenação
        if (produtos.isEmpty()) { // Verifica se a lista de produtos está vazia
            JOptionPane.showMessageDialog(this, "Nenhum produto cadastrado!", "Informação", JOptionPane.INFORMATION_MESSAGE); // Informa que não há produtos
        } else {
            jTextLista.setText(produtos); // Exibe a lista de produtos na interface
        }

    }//GEN-LAST:event_jButtonListarNORActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // Obtém o tipo de produto selecionado no combo box
        String tipo = (String) jComboBox.getSelectedItem();

        // Ajusta a visibilidade dos campos com base no tipo de produto selecionado
        if (tipo.equals("Alimento")) {
            jTextMarca.setVisible(false); // Oculta o campo de marca para alimentos
            jTextModelo.setVisible(false); // Oculta o campo de modelo para alimentos
            jTextValidade.setVisible(true); // Exibe o campo de validade para alimentos
        } else if (tipo.equals("Eletrônico")) {
            jTextMarca.setVisible(true); // Exibe o campo de marca para eletrônicos
            jTextModelo.setVisible(true); // Exibe o campo de modelo para eletrônicos
            jTextValidade.setVisible(false); // Oculta o campo de validade para eletrônicos
        }

    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jTextPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecoActionPerformed

    private void jTextQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextQtdActionPerformed

    private void jTextMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMarcaActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        // Obtém o nome do produto a ser removido da interface
        String nome = jTextNome.getText();

        // Chama o controlador para remover o produto com o nome fornecido
        boolean removido = controller.removerProduto(nome);

        // Verifica se a remoção foi bem-sucedida e exibe a mensagem correspondente
        if (removido) {
            JOptionPane.showMessageDialog(this, "Produto removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            atualizarListaProdutos();
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jTextValidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextValidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextValidadeActionPerformed

    private void jTextModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextModeloActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try {
            // Obtém os valores dos campos de entrada
            String tipo = (String) jComboBox.getSelectedItem();
            String nome = jTextNome.getText();
            String precoStr = jTextPreco.getText();
            String quantidadeStr = jTextQtd.getText();
            String marca = jTextMarca.getText();
            String modelo = jTextModelo.getText();
            String dataValidade = jTextValidade.getText();

            // Chama o método do controlador para adicionar o produto
            controller.adicionarProduto(tipo, nome, precoStr, quantidadeStr, marca, modelo, dataValidade);

            // Exibe uma mensagem de sucesso ao usuário
            JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos(); // Limpa os campos de entrada após a adição

        } catch (IllegalArgumentException e) {  // Captura e trata exceções lançadas pelo controlador
            // Exibe uma mensagem de erro ao usuário
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // Obtém o nome do produto do campo de texto, removendo espaços em branco
        String nome = jTextNome.getText().trim();

        // Busca o produto no controlador pelo nome fornecido
        Produto produto = controller.buscarProduto(nome);

        if (produto != null) {
            try {
                // Coleta os novos dados do usuário através de caixas de diálogo
                String novoNome = JOptionPane.showInputDialog(this, "Insira um Novo Nome:", produto.getNome());
                if (novoNome == null) {
                    return; // Verifica se o usuário cancelou a operação
                }
                double novoPreco = Double.parseDouble(JOptionPane.showInputDialog(this, "Insira um Novo Preço:", produto.getPreco()));
                int novaQtd = Integer.parseInt(JOptionPane.showInputDialog(this, "Insira uma Nova Quantidade:", produto.getQuantidadeEmEstoque()));

                // Atualiza os dados básicos do produto no controlador
                controller.editarProduto(produto, novoNome, novoPreco, novaQtd);

                // Exibe uma mensagem de sucesso ao usuário
                JOptionPane.showMessageDialog(this, "Produto editado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos(); // Limpa os campos de entrada após a edição

            } catch (NumberFormatException e) {
                // Trata erros de conversão de número e exibe mensagem de erro
                JOptionPane.showMessageDialog(this, "Preço ou quantidade inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Informa ao usuário que o produto não foi encontrado
            JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // Obtém os dados de entrada do usuário, removendo espaços desnecessários
        String nome = jTextNome.getText().trim();
        String modelo = jTextModelo.getText().trim();
        String marca = jTextMarca.getText().trim();
        String quantidadeStr = jTextQtd.getText().trim();

        // Chama o controlador para pesquisar produtos com os critérios fornecidos
        Set<Produto> resultados = controller.pesquisarProdutos(nome, marca, modelo, quantidadeStr);

        // Verifica se nenhum produto foi encontrado e exibe mensagem
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum produto encontrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Constrói uma string com os detalhes dos produtos encontrados
            StringBuilder produtos = new StringBuilder();
            for (Produto produto : resultados) {
                produtos.append(produto).append("\n"); // Adiciona cada produto à lista
            }
            jTextLista.setText(produtos.toString()); // Exibe a lista de produtos na interface
        }
        limparCampos(); // Limpa os campos de entrada após a pesquisa
    }//GEN-LAST:event_jButtonSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonListarNOR;
    private javax.swing.JButton jButtonListarOR;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelQtd;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelValidade;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextArea jTextLista;
    private javax.swing.JTextField jTextMarca;
    private javax.swing.JTextField jTextModelo;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextPreco;
    private javax.swing.JTextField jTextQtd;
    private javax.swing.JTextField jTextValidade;
    // End of variables declaration//GEN-END:variables
}
