package dzenang;

import java.io.FilterOutputStream;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

  public static void main(String[] args) {

    // creating runnable, named implementation
    Runnable runnable1 = new RunnableExample();
    Runnable runnable2 = new RunnableExample();

    // creating runnable, anonymous implementation
    Runnable runnable3 = new Runnable() {
      @Override
      public void run() {
        try {
          // this implementation is different than one in RunnableExample class
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println("Thread interrupted: " + Thread.currentThread().getName());
        }
      }
    };

    Callable<String> callable1 = new Callable<String>() {
      @Override
      public String call() throws Exception {
        // we need to provide some task definition here
        Thread.sleep(500);
        System.out.println("Anonymous class call()");
        return "Executing: ";
      }
    };

    Callable<String> callable2 = new CallableClass();
    Callable<String> callable3 = new CallableClass();
    Callable<String> callable4 = new CallableClass();

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    List<Callable<String>> callableList = List.of(callable4, callable1, callable2, callable3);

    // will just wait for first task to execute successfully
//    try {
//      String result = executorService.invokeAny(callableList);
//      System.out.println("Result is: " + result);
//    } catch (InterruptedException | ExecutionException e) {
//      System.out.println("Some problem working with threads using invokeAny.");
//    }

    // will wait for all tasks to execute
    try {
      List<Future<String>> futureList = executorService.invokeAll(callableList);
      System.out.println("======Results:======");
      for (Future<String> future : futureList) {
        System.out.println(future.get());
      }
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("Some problem working with threads using invokeAll.");
    }

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.out.println("Thread interrupted: " + Thread.currentThread().getName());
    }
    executorService.shutdown();
  }
}