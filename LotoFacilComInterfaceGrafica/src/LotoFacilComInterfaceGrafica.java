import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class LotoFacilComInterfaceGrafica extends JFrame {

    private JButton botao1;
    private JButton botao2;
    private JButton botao3;
    private JButton botao4;
    private JLabel imagemLabel;
    private Random random;

    public LotoFacilComInterfaceGrafica() {

        random = new Random();
        prepararGUI();
    }

    public static void main(String[] args) {

        LotoFacilComInterfaceGrafica gui = new LotoFacilComInterfaceGrafica();
    }

    private void prepararGUI() {

        setTitle("LOTOFÁCIL");
        setSize(500, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.gray);

        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 40));
        setLocationRelativeTo(null);
        
        ImageIcon imagemPadrao = new ImageIcon(getClass().getResource("sorteio.png"));
        imagemLabel = new JLabel(imagemPadrao);
        add(imagemLabel);

        botao1 = new JButton("Apostar de 0 a 100");
        botao1.setPreferredSize(new Dimension(300, 50));

        botao2 = new JButton("Apostar de A à Z");
        botao2.setPreferredSize(new Dimension(300, 50));

        botao3 = new JButton("Apostar em par ou ímpar");
        botao3.setPreferredSize(new Dimension(300, 50));

        botao4 = new JButton("Sair");
        botao4.setPreferredSize(new Dimension(300, 50));

        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarIntervalo();
            }
        });

        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarLetra();
            }
        });

        botao3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarParImpar();
            }
        });

        botao4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(botao1);
        add(botao2);
        add(botao3);
        add(botao4);

        setVisible(true);
    }

    private void apostarIntervalo() {

        int apostaUsuario = Integer.parseInt(JOptionPane.showInputDialog("Insira um número entre 0 e 100:"));

        if (apostaUsuario < 0 || apostaUsuario > 100) {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
            return;
        }

        int numeroAleatorio = random.nextInt(101);

        if (apostaUsuario == numeroAleatorio) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! O número sorteado foi: " + numeroAleatorio);
        }
    }

    private void apostarLetra() {

        char letraPremiada = 'H';

        String letraUsuario = JOptionPane.showInputDialog("Insira uma letra:").toUpperCase();

        if (letraUsuario.length() != 1 || !Character.isLetter(letraUsuario.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
            return;
        }

        char letra = letraUsuario.charAt(0);

        if (letra == letraPremiada) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraPremiada);
        }
    }

    private void apostarParImpar() {

        int numero = Integer.parseInt(JOptionPane.showInputDialog("Insira um número inteiro:"));

        if (numero % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
        }
    }
}