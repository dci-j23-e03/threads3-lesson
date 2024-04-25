package dzenang;

import java.util.concurrent.Callable;

public class CallableClass implements Callable<String> {

  @Override
  public String call() throws Exception {
    Thread.sleep(500);
    System.out.println("CallableClass call()");
    return "Class definition. Executing: ";
  }
}
