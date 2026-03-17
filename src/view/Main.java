package view;

import controller.RedesController;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        RedesController redes = new RedesController();

        int opcao = 0;

        while (opcao != 9) {

            opcao = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "1 - Ver IP\n2 - Testar Ping\n9 - Sair"
                    )
            );

            switch (opcao) {

                case 1:
                    redes.ip();
                    break;

                case 2:
                    redes.ping();
                    break;

                case 9:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }
}