package Threads;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sodobescu on 4/19/2017.
 */
public class MaxValue extends Thread {
	private static int THREAD_POOL_COUNT= 4;
	private int start;
	private int end;
	private List<Integer> array = new ArrayList<>();
	private static int maxValue;

	public MaxValue(int start, int max, List<Integer> array) {
		
		this.array = array;
		this.setStart(start);
		this.setEnd(end);
	
	}

	@Override
	public void run() {
		maxValue=Collections.max(array.subList(start, end));	 
	}

	public static int searchMaxValue(List<Integer> array) throws InterruptedException {
		
		assert array.size() > 3;
		int sizeOfList = array.size();

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for (int i = 0; i < THREAD_POOL_COUNT; i++) {
			MaxValue thread=new MaxValue((i * sizeOfList) / 4, ((i + 1) * sizeOfList) / 4, array);
			executorService.execute(thread);
			}
		sleep(1000);
		executorService.shutdown();
		return maxValue;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		if(start<this.array.size()-1 && start>0)
		this.start = start;
		else this.start=0;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		if(end<this.array.size() && end>0 && end>start)
			this.end = end;
			else this.end=this.array.size()-1;
	}

}
