package dzenang;

public class Example {

  public static void main(String[] args) {
    // we can create runnable in different place with RunnableExample class
    Runnable runnableExample = new RunnableExample();

    // if we want runnable with 1000 millis wait, then we need to duplicate code
    // in case we need the same implementation at multiple places, that would be a good time to
    // create a class
    Runnable runnableWith1000Millis = new Runnable() {
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
  }
}
