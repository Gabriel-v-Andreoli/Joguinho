import java.util.Scanner;

public class Jogo {
    private PilhaEncadeada p1;
    private PilhaEncadeada p2;
    private PilhaEncadeada p3;

    public Jogo(){
        p1 = null;
        p2 = null;
        p3 = null;
    }

    public void popularP1(int num){
        int max = 100;
        int min = 0;
        int range = max - min + 1;
        for (int i = 0; i < num; i++) {
            int rand = (int)(Math.random() * range) + min;
            if (p1 == null){
                PilhaEncadeada pilhaTemporaria = new PilhaEncadeada();
                pilhaTemporaria.insert(rand);
                p1 = pilhaTemporaria;
            } else {
                p1.insert(rand);
            }
        }
    }

    public void printGame(){
        Node a1 = p1.getUltimo();
        if (p2 == null && p3 == null){
            while (a1 != null){
                System.out.printf("%d/ -/ -%n", a1.getInfo());
                a1 = a1.getProx();
            }
        } else if (p2 != null && p3 == null) {
            Node a2 = p2.getUltimo();
            do {
                if (a1 != null) {
                    System.out.printf("%d/ ", a1.getInfo());
                    a1 = a1.getProx();
                } else {
                    System.out.print("-/ ");
                } if (a2 != null) {
                    System.out.printf("%d/ ", a2.getInfo());
                    a2 = a2.getProx();
                } else {
                    System.out.print("-/ ");
                }

                System.out.println("- ");
            } while (a1 != null && a2 != null);
        } else if (p2 == null && p3 != null) {
            Node a3 = p3.getUltimo();
            do {
                if (a1 != null) {
                    System.out.printf("%d/ ", a1.getInfo());
                    a1 = a1.getProx();
                } else {
                    System.out.print("-/ ");
                }
                System.out.print("-/ ");
                if (a3 != null) {
                    System.out.printf("%d/ ", a3.getInfo());
                    a3 = a3.getProx();
                } else {
                    System.out.print("-/ ");
                }

                System.out.println();
            } while (a1 != null && a3 != null);
        } else {
            Node a2 = p2.getUltimo();
            Node a3 = p3.getUltimo();
            do {
                if (a1 != null) {
                    System.out.printf("%d/ ", a1.getInfo());
                    a1 = a1.getProx();
                } else {
                    System.out.print("-/ ");
                } if (a3 != null){
                    System.out.printf("%d/ ", a3.getInfo());
                    a3 = a3.getProx();
                } else {
                    System.out.print("-/ ");
                }if (a2 != null) {
                    System.out.printf("%d/ ", a2.getInfo());
                    a2 = a2.getProx();
                } else {
                    System.out.print("-/ ");
                }

                System.out.println("- ");
            } while (a1 != null && a2 != null && a3 != null);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogo jogo = new Jogo();
        System.out.println("Deseja jogar com quantos elementos? ");
        int r = sc.nextInt();
        jogo.popularP1(r);
        jogo.printGame();
    }
}
