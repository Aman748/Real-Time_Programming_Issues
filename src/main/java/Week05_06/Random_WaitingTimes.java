package Week05_06;

/**
 *
 * @author Aman
 */
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Random_WaitingTimes {

public static void main(String[] args) throws InterruptedException {
    ThreadNumber thread = new ThreadNumber();
    Thread t1 = new Thread(thread, "Thread-1");
    Thread t2 = new Thread(thread, "Thread-2"); 
    t1.start();
    t1.sleep(thread.getT1WaitingTime());
    t2.start();
    t2.sleep(thread.getT2WaitingTime());
    t1.join();
    t2.join();
    System.out.println(t1.getName()+ " = " + thread.getCountT1());
    System.out.println(t2.getName()+ " = " + thread.getCountT2());
    System.out.println("Total = " + thread.getTotalNumber());
}

static class ThreadNumber implements Runnable{
    
    private int totalNumber, randomNumber, t1WaitingTime, t2WaitingTime;
    private final AtomicInteger total = new AtomicInteger();
    private final AtomicInteger countT1 = new AtomicInteger();
    private final AtomicInteger countT2 = new AtomicInteger();
    
    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    @Override
    public void run(){
        while(totalNumber < 1000){
            totalNumber = total.incrementAndGet();
            randomNumber = getRandomNumberInRange(500, 3000);
            if(Thread.currentThread().getName().equals("Thread-1")){
                countT1.incrementAndGet();
                t1WaitingTime = randomNumber;
            }
            else if(Thread.currentThread().getName().equals("Thread-2")){
                countT2.incrementAndGet();
                t2WaitingTime = randomNumber;
            }
            
            if(countT1.get() > countT2.get()){
                countT1.decrementAndGet();
                countT2.incrementAndGet();
            }
        }
    }
    
    public int getCountT1() {
        return this.countT1.get();
    }
    
    public int getCountT2() {
        return this.countT2.get();
    }
    
    public int getTotalNumber() {
        return totalNumber;
    }
    
    public int getT1WaitingTime() {
        return t1WaitingTime;
    }
    
    public int getT2WaitingTime() {
        return t2WaitingTime;
    }
}
}
