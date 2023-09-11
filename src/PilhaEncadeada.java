import java.util.Scanner;

public class PilhaEncadeada {
    private Node lista;
    private Node ultimo;

    public PilhaEncadeada() {
        lista = null;
        ultimo = null;
    }

    public Node getUltimo() {
        return ultimo;
    }

    public void insert(int num){
        Node no = new Node();
        no.setInfo(num);
        if (lista == null){
            lista = no;
        } else {
            no.setProx(ultimo);
        }
        ultimo = no;
    }

    public void insertNode(Node node){
        if (lista == null){
            lista = node;
        } else {
            node.setProx(ultimo);
        }
        ultimo = node;
    }

    public void remove(){
        if (lista != null){
            System.out.printf("O valor removido foi %d%n", ultimo.getInfo());
            if (ultimo != lista){
                ultimo = ultimo.getProx();
            } else {
                ultimo = null;
                lista = null;
            }
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public void print(){
        Node atual = ultimo;
        while (atual != null){
            System.out.println(atual.getInfo());
            atual = atual.getProx();
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaEncadeada pe = new PilhaEncadeada();

        System.out.println("Teste da pilha");
        while (true){
            System.out.print("Digite um número: ");
            int r = sc.nextInt();
            if (r == 0){
                break;
            } else {
                pe.insert(r);
            }
        }
        System.out.println("A lista criada-> ");
        System.out.println();
        pe.print();
        while (true){
            System.out.println();
            System.out.println("Oq deseja fazer mestre?");
            System.out.println("1- inserir mais números");
            System.out.println("2- remover ultimo elemento da pilha");
            System.out.println("3- imprimir");
            System.out.println("qualquer outra número para o programa");
            int resp = sc.nextInt();
            if (resp == 1){
                while (true){
                    System.out.print("Digite um número: ");
                    int r = sc.nextInt();
                    if (r == 0){
                        break;
                    } else {
                        pe.insert(r);
                    }
                }
            } else if (resp == 2){
                pe.remove();
            } else if (resp == 3) {
                pe.print();
            } else {
                break;
            }
        }
    }
}
