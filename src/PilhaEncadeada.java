public class PilhaEncadeada {
    private Node lista;
    private Node ultimo;
    private Integer lenth;
    public PilhaEncadeada() {
        lista = null;
        ultimo = null;
        lenth = 0;
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
        lenth++;
    }

    public void remove(){
        if (lista != null){
            if (ultimo != lista){
                ultimo = ultimo.getProx();
            } else {
                ultimo = null;
                lista = null;
            }
            lenth--;
        }
    }

    public void print(){
        Node atual = ultimo;
        while (atual != null){
            System.out.println(atual.getInfo());
            atual = atual.getProx();
        }
    }

    public Integer getLenth(){
        return lenth;
    }
}
