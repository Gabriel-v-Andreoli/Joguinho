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
   public PilhaEncadeada pegaOrigem(int n){
       if (n == 1){
           return p1;
       } else if (n == 2){
           return  p2;
       } else {
           return p3;
       }
   }

    public PilhaEncadeada pegaDestino(int n){
        if (n == 1){
            return p1;
        } else if (n == 2){
            return  p2;
        } else {
            return p3;
        }
    }
   public void move(PilhaEncadeada origem, PilhaEncadeada destino){
       Node temporario = origem.getUltimo();
       origem.remove();
       destino.insert(temporario.getInfo());
   }

   public boolean verificaDecrescente(){
        if ( p2.getUltimo() == null && p3.getUltimo() == null){
            Node ultimo = p1.getUltimo();
            while (ultimo.getProx() != null){
                if (ultimo.getInfo() <= ultimo.getProx().getInfo()){
                    ultimo = ultimo.getProx();
                } else {
                    return false;
                }
            }
            return true;
        } else if (p1.getUltimo() == null && p3.getUltimo() == null) {
            Node ultimo = p2.getUltimo();
            while (ultimo.getProx() != null){
                if (ultimo.getInfo() <= ultimo.getProx().getInfo()){
                    ultimo = ultimo.getProx();
                } else {
                    return false;
                }
            }
            return true;
        } else if (p1.getUltimo() == null && p2.getUltimo() == null){
            Node ultimo = p3.getUltimo();
            while (ultimo.getProx() != null){
                if (ultimo.getInfo() <= ultimo.getProx().getInfo()){
                    ultimo = ultimo.getProx();
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
       if ( p2.getUltimo() == null && p3.getUltimo() == null){
           Node ultimo = p1.getUltimo();
           while (ultimo.getProx() != null){
               if (ultimo.getInfo() >= ultimo.getProx().getInfo()){
                   ultimo = ultimo.getProx();
               } else {
                   return false;
               }
           }
           return true;
       } else if (p1.getUltimo() == null && p3.getUltimo() == null) {
           Node ultimo = p2.getUltimo();
           while (ultimo.getProx() != null){
               if (ultimo.getInfo() >= ultimo.getProx().getInfo()){
                   ultimo = ultimo.getProx();
               } else {
                   return false;
               }
           }
           return true;
       } else if (p1.getUltimo() == null && p2.getUltimo() == null){
           Node ultimo = p3.getUltimo();
           while (ultimo.getProx() != null){
               if (ultimo.getInfo() >= ultimo.getProx().getInfo()){
                   ultimo = ultimo.getProx();
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
