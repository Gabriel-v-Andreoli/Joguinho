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
            if (ultimo != lista){
                ultimo = ultimo.getProx();
            } else {
                ultimo = null;
                lista = null;
            }
        }
    }

    public void print(){
        Node atual = ultimo;
        while (atual != null){
            System.out.println(atual.getInfo());
            atual = atual.getProx();
        }
    }
}
