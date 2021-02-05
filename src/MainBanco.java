import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainBanco {


    public static void main(String[] args) throws InterruptedException {
        CompteEstalvi compte = new CompteEstalvi();
        compte.saldo = 0;
        Runnable pIngres = () -> compte.ingressar(1000);
        Runnable pTreure = () -> compte.treure(500);

        Thread tIngres = null;
        Thread tTreure = null;


        for(int i = 0; i<1000;i++){

            tIngres = new Thread(pIngres);
            tTreure = new Thread(pTreure);
            tIngres.start();
            tTreure.start();

        }
        tIngres.join();
        tTreure.join();



        System.out.println("Saldo: "+compte.saldo);



    }
}
