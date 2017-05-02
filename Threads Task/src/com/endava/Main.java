import Threads.MaxValue;
import Threads.ReverseHello;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
/**
 * Created by sodobescu on 4/19/2017.
 */
public class Main
{

	    public static void main(String[] args) throws InterruptedException {

	    	/*
	    	 * Fill an array with random numbers
	    	 */
        ArrayList<Integer> array = new ArrayList<Integer>();
        int arraySize=100;
	        for (int i = 0; i <arraySize ; i++)
            array.add((int)(20 + Math.random() * 1000));
	
       int maxValue = MaxValue.searchMaxValue(array);
	
	
        System.out.println("MaxValue: " + maxValue);
	    
       array.forEach(System.out::println);
	    	
	    	
	    	
	        ReverseHello reverseHello = new ReverseHello();
	        reverseHello.start();


	        AtomicInteger atomicInteger = new AtomicInteger(0);
	        Thread thread = new Thread(() -> {
	            for (int i = 0; i < 4000; i++){
	                atomicInteger.incrementAndGet();
	            }
	        });
	        thread.start();

	       thread.sleep(1000);
	        System.out.println(atomicInteger);
	    }
}