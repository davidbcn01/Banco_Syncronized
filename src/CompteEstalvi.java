public class CompteEstalvi {
    int saldo;

    public synchronized   void ingressar(int dinero){
        saldo= saldo+ dinero;
    }
    public synchronized void treure(int dinero){
        saldo= saldo-dinero;
    }
}
