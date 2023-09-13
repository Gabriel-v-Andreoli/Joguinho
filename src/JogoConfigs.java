import java.util.Objects;

public class JogoConfigs {
   private PilhaEncadeada p1;
   private PilhaEncadeada p2;
   private PilhaEncadeada p3;
   private Integer movimentos = 0;
   private Integer maiorP1;
   private Integer maiorP3;

   private Integer menorP1;
   private Integer menorP3;

   public JogoConfigs(){
       p1 = new PilhaEncadeada();
       p2 = new PilhaEncadeada();
       p3 = new PilhaEncadeada();
   }

    public int getMovimentos() {
        return movimentos;
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

   public int achaMaior(PilhaEncadeada origem){
       int maior = -1;
       Node no = origem.getUltimo();
       for (int i = 0; i < origem.getLenth(); i++) {
           if (maior == -1){
               maior = no.getInfo();
               no = no.getProx();
           } else if (maior < no.getInfo()){
               maior = no.getInfo();
               no = no.getProx();
           } else {
               no = no.getProx();
           }
       }
       return maior;
   }

   public int achaMenor(PilhaEncadeada origem){
       Node no = origem.getUltimo();
       int menor = -1;
       for (int i = 0; i < origem.getLenth(); i++) {
           if (menor == -1){
               menor = no.getInfo();
               no = no.getProx();
           } else if (menor > no.getInfo()) {
               menor = no.getInfo();
               no = no.getProx();
           } else {
               no = no.getProx();
           }
       }
       return menor;
   }

   public void resolucaoAutomaticaDecrescente() {
       if (p1.getUltimo() != null) {
           maiorP1 = achaMaior(p1);
           if (p2.getUltimo() == null && p3.getUltimo() == null) {
               if (p1.getUltimo().getInfo() == maiorP1) {
                   move(p1, p2);
               } else {
                   move(p1, p3);
               }
           } else if (p3.getUltimo() != null) {
               maiorP3 = achaMaior(p3);
               if (maiorP1 > maiorP3) {
                   if (p1.getUltimo().getInfo() == maiorP1) {
                       move(p1, p2);
                   } else {
                       move(p1, p3);
                   }
               } else {
                   if (p3.getUltimo().getInfo() == maiorP3) {
                       move(p3, p2);
                   } else {
                       move(p3, p1);
                   }
               }
           } else if (p3.getUltimo() == null && p2.getUltimo() != null) {
               if (p1.getUltimo().getInfo() == maiorP1) {
                   move(p1, p2);
               } else {
                   move(p1, p3);
               }
           }
       } else if (p1.getUltimo() == null) {
           maiorP3 = achaMaior(p3);
           if (p3.getUltimo().getInfo() == maiorP3) {
               move(p3, p2);
           } else {
               move(p3, p1);
           }
       }
       movimentos++;
   }

    public void resolucaoAutomaticaCrescente(){
       if (p1.getUltimo() != null){
           menorP1 = achaMenor(p1);
           if (p2.getUltimo() == null && p3.getUltimo() == null){
               if (p1.getUltimo().getInfo() == menorP1){
                   move(p1, p2);
               } else {
                   move(p1, p3);
               }
           }else if (p3.getUltimo() != null) {
               menorP3 = achaMenor(p3);
               if (menorP1 < menorP3) {
                   if (p1.getUltimo().getInfo() == menorP1) {
                       move(p1, p2);
                   } else {
                       move(p1, p3);
                   }
               } else {
                   if (p3.getUltimo().getInfo() == menorP3) {
                       move(p3, p2);
                   } else {
                       move(p3, p1);
                   }
               }
           } else if (p3.getUltimo() == null && p2.getUltimo() != null) {
               if (p1.getUltimo().getInfo() == menorP1) {
                   move(p1, p2);
               } else {
                   move(p1, p3);
               }
           }
       }else if (p1.getUltimo() == null) {
           menorP3 = achaMenor(p3);
           if (p3.getUltimo().getInfo() == menorP3){
               move(p3,p2);
           } else {
               move(p3,p1);
           }
       }
       movimentos++;
   }
}
