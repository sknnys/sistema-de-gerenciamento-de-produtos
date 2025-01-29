
package main;

import view.ProdutoView;

/**
 *
 * @author hudrson.silva
 */
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ProdutoView().setVisible(true);
        });
    }
}
