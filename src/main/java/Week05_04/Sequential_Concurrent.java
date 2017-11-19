package Week05_04;

/**
 *
 * @author Aman
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sequential_Concurrent extends Thread{

    long startTime, endTime, duration;

    public static void main(String[] args){
        seq.start();
        con.start();
        }

    static Sequential_Concurrent seq = new Sequential_Concurrent(){
        @Override
        public void run() {
            startTime = System.nanoTime();
            int max = 0;
            for(int i=0; i < 1000000; i++){
                int x = (int) ((Math.random())*1000000);
                max = Math.max(max,x);
            }
            endTime = System.nanoTime();
            System.out.printf("Sequential Program = %.8f seconds %n", (endTime - startTime)/1000000000.0);
        }
    };

    static Sequential_Concurrent con = new Sequential_Concurrent(){
        @Override
        public void run() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(()-> {
                startTime = System.nanoTime();
                int max = 0;
                for(int i=0; i < 1000000; i++){
                    int x = (int) ((Math.random())*1000000);
                    max = Math.max(max,x);
                }
            });
            executor.shutdown();
            while (!executor.isTerminated()) {
            }    
            endTime = System.nanoTime();
            System.out.printf("Concurrent Program = %.8f seconds %n", (endTime - startTime)/1000000000.0);
        }
    };
}