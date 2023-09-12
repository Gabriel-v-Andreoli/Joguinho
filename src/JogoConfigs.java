public class JogoConfigs {
   private PilhaEncadeada p1;
   private PilhaEncadeada p2;
   private PilhaEncadeada p3;

   public JogoConfigs(){
       p1 = new PilhaEncadeada();
       p2 = new PilhaEncadeada();
       p3 = new PilhaEncadeada();
   }

   public void popular(int tamanho){
       int max = 100;
       int min = 0;
       int range = max - min + 1;
       for (int i = 0; i < tamanho; i++) {
           int rand = (int)(Math.random() * range) + min;
           p1.insert(rand);
       }
   }
   public PilhaEncadeada pegaPilha(int n){
       if (n == 1){
           return p1;
       } else if (n == 2){
           return  p2;
       } else {
           return p3;
       }
   }

    public boolean podeMover(PilhaEncadeada origem, PilhaEncadeada destino){
       if (origem.getUltimo() != null){
           return true;
       } else {
           return false;
       }
    }
   public void move(PilhaEncadeada origem, PilhaEncadeada destino){
       Node temporario = origem.getUltimo();
       origem.remove();
       destino.insert(temporario.getInfo());
   }

   public boolean verificaDecrescente(){
        Node no = new Node();
        if ( p2.getUltimo() == null && p3.getUltimo() == null){
            no = p1.getUltimo();
            for (int i = 1; i < p1.getLenth(); i++) {
                if (no.getInfo() <= no.getProx().getInfo()){
                    no = no.getProx();
                } else {
                    return false;
                }
            }
            return true;
        } else if (p1.getUltimo() == null && p3.getUltimo() == null) {
            no = p2.getUltimo();
            for (int i = 1; i < p2.getLenth(); i++) {
                if (no.getInfo() <= no.getProx().getInfo()){
                    no = no.getProx();
                } else {
                    return false;
                }
            }
            return true;
        } else if (p1.getUltimo() == null && p2.getUltimo() == null){
            no = p3.getUltimo();
            for (int i = 1; i < p3.getLenth(); i++) {
                if (no.getInfo() <= no.getProx().getInfo()){
                    no = no.getProx();
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
   }

   public boolean verificacaoCrescente(){
       Node no = new Node();
       if ( p2.getUltimo() == null && p3.getUltimo() == null){
           no = p1.getUltimo();
           for (int i = 1; i < p1.getLenth(); i++) {
               if (no.getInfo() >= no.getProx().getInfo()){
                   no = no.getProx();
               } else {
                   return false;
               }
           }
           return true;
       } else if (p1.getUltimo() == null && p3.getUltimo() == null) {
           no = p2.getUltimo();
           for (int i = 1; i < p2.getLenth(); i++) {
               if (no.getInfo() >= no.getProx().getInfo()){
                   no = no.getProx();
               } else {
                   return false;
               }
           }
           return true;
       } else if (p1.getUltimo() == null && p2.getUltimo() == null){
           no = p3.getUltimo();
           for (int i = 1; i < p3.getLenth(); i++) {
               if (no.getInfo() >= no.getProx().getInfo()){
                   no = no.getProx();
               } else {
                   return false;
               }
           }
           return true;
       } else {
           return false;
       }
   }

   public void printBoard(){
       Node a1 = p1.getUltimo();
       Node a2 = p2.getUltimo();
       Node a3 = p3.getUltimo();

       if (a1 != null) {
           System.out.print("Pilha 1: ");
           while (a1.getProx() != null) {
               System.out.printf("%d <- ", a1.getInfo());
               a1 = a1.getProx();
           }
           System.out.printf("%d%n", a1.getInfo());
       } else {
           System.out.println("Pilha 1: null");
       }

       if (a2 != null) {
           System.out.print("Pilha 2: ");
           while (a2.getProx() != null) {
               System.out.printf("%d <- ", a2.getInfo());
               a2 = a2.getProx();
           }
           System.out.printf("%d%n", a2.getInfo());
       } else {
           System.out.println("Pilha 2: null");
       }

       if (a3 != null) {
           System.out.print("Pilha 3: ");
           while (a3.getProx() != null) {
               System.out.printf("%d <- ", a3.getInfo());
               a3 = a3.getProx();
           }
           System.out.printf("%d%n", a3.getInfo());
       } else {
           System.out.println("Pilha 3: null");
       }
       System.out.println();
   }
}
