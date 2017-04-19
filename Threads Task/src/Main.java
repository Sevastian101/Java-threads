import Threads.ReverseHello;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Created by sodobescu on 4/19/2017.
 */
public class Main
{
	public static void main(String args[]) throws InterruptedException {

		ReverseHello a = new ReverseHello();
		a.start();
		taskFive();
	}
	public static void taskFive() throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		final AtomicInteger atomicInteger = new AtomicInteger(5);

		for(int i = 0; i < 3; ++i) {
			executorService.submit(() -> {
				System.out.println(atomicInteger.updateAndGet((value) -> value + 5));
			});
		}



	}

}
