import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        JogoConfigs jogo = new JogoConfigs();
        Scanner sc = new Scanner(System.in);
        int tamanho;
        int opcao;
        int o;
        int d;
        int contador = 0;

        System.out.println("Bem vindo ao jogo!");
        System.out.println("Qual é o tamanho da pilha?");
        tamanho = sc.nextInt();
        jogo.popular(tamanho);


        System.out.println("Deseja resolver o jogo em ordem decrescente (1) ou crescente (2) ?");
        opcao = sc.nextInt();
        if (opcao == 1){
            System.out.println("Bom jogo");
            System.out.println();
            while (true){
                jogo.printBoard();
                System.out.printf("Jogadas usadas: %d%n", contador);
                System.out.println("Opções: ");
                System.out.println("0- sair");
                System.out.println("1- Mover");
                System.out.println("2- resolução automatica");
                opcao = sc.nextInt();
                if (opcao == 0){
                    System.out.printf("Quantidade de jogadas usadas: %d", contador);
                    break;
                } else if (opcao == 1) {
                    System.out.print("Pilha de Origem (1/ 2/ 3): ");
                    o = sc.nextInt();
                    System.out.print("Pilha de Destino (1/ 2/ 3): ");
                    d = sc.nextInt();
                    if (jogo.podeMover(jogo.pegaPilha(o), jogo.pegaPilha(d))) {
                        jogo.move(jogo.pegaPilha(o), jogo.pegaPilha(d));
                        contador++;
                    }
                    if (jogo.verificaDecrescente()){
                        System.out.println();
                        jogo.printBoard();
                        System.out.println("Parabens!!!!!");
                        System.out.printf("Voce ganhou com %d movimentos!", contador);
                        break;
                    }
                    System.out.println();
                } else if (opcao == 2){
                    while (true){
                        jogo.printBoard();
                        jogo.resolucaoAutomaticaDecrescente();
                        if (jogo.verificaDecrescente()){
                            System.out.println();
                            jogo.printBoard();
                            System.out.printf("O computador terminou em %d movimentos%n", jogo.getMovimentos());
                            break;
                        }
                    }
                    break;
                }
            }

        } else if (opcao == 2) {
            System.out.println("Bom jogo");
            System.out.println();
            while (true) {
                jogo.printBoard();
                System.out.printf("Jogadas usadas: %d%n", contador);
                System.out.println("Opções: ");
                System.out.println("0- sair");
                System.out.println("1- Mover");
                System.out.println("2- resolução automatica");
                opcao = sc.nextInt();
                if (opcao == 0) {
                    System.out.printf("Quantidade de jogadas usadas: %d", contador);
                    break;
                } else if (opcao == 1) {
                    System.out.print("Pilha de Origem (1/ 2/ 3): ");
                    o = sc.nextInt();
                    System.out.print("Pilha de Destino (1/ 2/ 3): ");
                    d = sc.nextInt();
                    if (jogo.podeMover(jogo.pegaPilha(o), jogo.pegaPilha(d))) {
                        jogo.move(jogo.pegaPilha(o), jogo.pegaPilha(d));
                        contador++;
                    }
                    if (jogo.verificacaoCrescente()) {
                        System.out.println();
                        jogo.printBoard();
                        System.out.println("Parabens!!!!!");
                        System.out.printf("Voce ganhou com %d movimentos!", contador);
                        break;
                    }
                    System.out.println();
                } else {
                    break;
                }
            }

        } else {
            System.out.println("Opção inválida");
        }
    }
}
