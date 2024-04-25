package dzenang;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {

  public static void main(String[] args) {

    ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
//    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

    scheduledExecutor.schedule(new RunnableExample(), 3, TimeUnit.SECONDS);
    Future<String> callableFuture = scheduledExecutor.schedule(new CallableClass(), 500, TimeUnit.MILLISECONDS);
    scheduledExecutor.scheduleWithFixedDelay(new RunnableExample(), 100, 200, TimeUnit.MILLISECONDS);

    try {
      System.out.println("Result: " + callableFuture.get());
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("Some problem working with threads using schedule.");
    }

    scheduledExecutor.shutdown();
  }

}
