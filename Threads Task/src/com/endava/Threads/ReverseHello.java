package Threads;

/**
 * Created by sodobescu on 4/19/2017.
 */
public class ReverseHello extends Thread
{
	private static int numberOfThreads = 0;

	@Override
	public void run() {
		numberOfThreads++;

		if (numberOfThreads < 50) {
			ReverseHello a = new ReverseHello();
			a.start();
			try {
				a.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Hello from thread" + Thread.currentThread().getName());
	}


}
