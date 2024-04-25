package dzenang;

public class RunnableExample implements Runnable {

  @Override
  public void run() {
    try {
      System.out.println("RunnableExample class run()");
      Thread.sleep(100);
    } catch (InterruptedException e) {
      System.out.println("Thread interrupted: " + Thread.currentThread().getName());
    }
  }
}
