import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainBanco {


    public static void main(String[] args) throws InterruptedException {
        CompteEstalvi compte = new CompteEstalvi();
        compte.saldo = 0;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        Runnable pIngres = () -> compte.ingressar(1000);
        Runnable pTreure = () -> compte.treure(500);
        for(int i = 0; i<1000;i++){
        executor.execute(pIngres);
        executor.execute(pTreure);

        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(compte.saldo);
    }



}
