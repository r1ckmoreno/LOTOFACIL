import java.util.Random;
import java.util.Scanner;

public class LotoFacil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int escolhaUsuario;
        boolean emExecucao = true;

        while (emExecucao) {
            System.out.println("**************************");
            System.out.println("Menu LOTOFÁCIL:");
            System.out.println("1) Apostar de 0 a 100");
            System.out.println("2) Apostar de A à Z");
            System.out.println("3) Apostar em par ou ímpar");
            System.out.println("0) Sair");
            System.out.println("**************************");
            System.out.print("Escolha uma opção: ");
            escolhaUsuario = scanner.nextInt();

            switch (escolhaUsuario) {
                case 1:
                    apostarIntervalo(scanner, random);
                    break;
                case 2:
                    apostarLetra(scanner);
                    break;
                case 3:
                    apostarParImpar(scanner);
                    break;
                case 0:
                    emExecucao = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void apostarIntervalo(Scanner scanner, Random random) {
        int apostaUsuario, numeroAleatorio;

        System.out.print("Insira um número entre 0 e 100: ");
        apostaUsuario = scanner.nextInt();

        if (apostaUsuario < 0) {
            System.out.println("Aposta inválida.");
            return;
        }
        if (apostaUsuario > 100) {
            System.out.println("Aposta inválida.");
            return;
        }

        numeroAleatorio = random.nextInt(101);
        System.out.println("Número sorteado: " + numeroAleatorio);

        if (apostaUsuario == numeroAleatorio) {
            System.out.println("Você ganhou R$ 1.000,00 reais.");
        } else {
            System.out.println("Que pena! O número sorteado foi: " + numeroAleatorio);
        }
    }

    private static void apostarLetra(Scanner scanner) {
        char letraPremiada = 'H';

        System.out.print("Insira uma letra: ");
        char letraUsuario = Character.toUpperCase(scanner.next().charAt(0));

        if (!Character.isLetter(letraUsuario)) {
            System.out.println("Aposta inválida.");
            return;
        }

        if (letraUsuario == letraPremiada) {
            System.out.println("Você ganhou R$ 500,00 reais.");
        } else {
            System.out.println("Que pena! A letra sorteada foi: " + letraPremiada);
        }
    }


    private static void apostarParImpar(Scanner scanner) {
        System.out.print("Insira um número inteiro: ");
        int numero = scanner.nextInt();

        if (numero % 2 == 0) {
            System.out.println("Você ganhou R$ 100,00 reais.");
        } else {
            System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
        }
    }
}
