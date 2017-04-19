package Threads;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sodobescu on 4/19/2017.
 */
public class MaxValue implements Runnable
{
	private int min;
	private int max;
	java.util.List<Integer> arr = new ArrayList<>();

	public MaxValue(int min, int max,int lenght) {
		this.min = min;
		this.max = max;
		for (int j = 0; j <lenght; j++) {
			arr.add(randInt(min,max));
		}
	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	@Override
	public void run() {
		System.out.println(Collections.max(arr));
	}

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(1);

		for (int i = 0; i < 4; i++) {
			Runnable worker = new MaxValue(i,i*3,i*5+1);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
