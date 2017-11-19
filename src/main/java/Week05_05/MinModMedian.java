package Week05_05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class MinModMedian extends Thread {

static Random Numbers = new Random();
static int[] List = new int[1000000];

public static void main(String[] args) {
    int sum;
    for (int i = 0; i < List.length; i++) {
        sum = Numbers.nextInt(List.length);
        List[i] = sum;
    }
    MIN.start();
    MOD.start();
    MEDIAN.start();
}

static Thread MIN = new Thread() {
    @Override
    public void run() {
        int mean, sum=0;
        for (int i = 0; i < List.length; i++) {
            sum += List[i];
        }
        mean = sum/List.length;
        System.out.println("MIN = " + mean);
    }
};

static Thread MOD = new Thread() {    
    @Override
    public void run() {       
        Map<Integer, Integer> Count = new HashMap<>();
        for (int i = 0; i < List.length; i++) {
            Integer v = Count.get(List[i]);
            Count.put(List[i], v == null ? 1 : v + 1);
        }
        HashSet<Integer> set = new HashSet<>();
	int maxValue = 0;
	for (Map.Entry<Integer, Integer> entry : Count.entrySet()) {
		if((int)entry.getValue() > maxValue){
			set.clear();
			set.add(entry.getKey());
			maxValue = entry.getValue();
		} else if((int)entry.getValue() == maxValue){
			set.add(entry.getKey());
		}
	}
        System.out.print("MOD = ");
        for(Integer mode:set){
            System.out.print(mode+" ");
        }
        System.out.println();
    }
};

static Thread MEDIAN = new Thread() {    
    @Override
    public void run() {
        int median;
        Arrays.sort(List);
        if ((List.length % 2) == 0) {
            median = ((List[List.length / 2]) + (List[(List.length / 2) - 1]))/2;
        } else {
            median = List[List.length / 2];
        }
        System.out.println("MEDIAN = " + median);
    }
};
}