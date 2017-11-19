package Week05_03;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Aman
 */
public class Compare_execution_times extends Thread {
    
    public static void main(String[] args){
        Syn.start();
        Nor.start();
    }
    
    public static void work(){
        ArrayList<String> list = new ArrayList<>();  
        list.add("one");  
        list.add("two");  
        list.add("two");  
        list.add("two");  
        list.add("two");  
        Iterator<String> iter = list.iterator();  
        while(iter.hasNext()){  
            String s = iter.next();  
            if(s.equals("two")){  
                iter.remove();  
            }  
        }
    }

    static Compare_execution_times Syn = new Compare_execution_times(){
        @Override
        public void run() {
            long startTime = System.nanoTime();
            synchronized (this) {
                for (int i = 0; i <= 10; i++) {
                    work();
                }
            }
            long endTime = System.nanoTime();
            System.out.printf("Synchronized Thread = %.8f seconds %n", (endTime - startTime)/1000000000.0);
        }
    };

    static Compare_execution_times Nor = new Compare_execution_times(){
        @Override
        public void run() {
            long startTime = System.nanoTime();
                for (int i = 0; i <= 10; i++) {
                    work();
                }
            long endTime = System.nanoTime();
            System.out.printf("Normal Thread = %.8f seconds %n", (endTime - startTime)/1000000000.0);
        }
    };
}
