package Lev16;
/*
Последовательные выполнения нитей
1. Разберись, что делает программа.
2. Сделай так, чтоб программа сначала выводила результат нити, а когда нить завершится - продолжила метод main.

3. Пример выходных данных:
inside MyThread 0
inside MyThread 1
...
inside MyThread 9
inside main 0
inside main 1
...
inside main 9


Требования:
1. Метод main должен вызывать метод start у нити t.
2. Метод main должен вызывать метод join у нити t.
3. Сначала программа должна вывести 10 строк начинающихся с "inside MyThread".
4. В конце программа должна вывести 10 строк начинающихся с "inside main".
5. Всего программа должна вывести 20 строк.
 */

public class Task1624 {
  public static MyThread t = new MyThread();
  static String message = "inside main ";

  public static void main(String a[]) throws Exception {
    t.start();
    for (int i = 0; i < 10; i++) {
      System.out.println(message + i);
      sleep();
    }
  }

  public static void sleep() {
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
    }
  }

  static class MyThread extends Thread {
    String message = "inside MyThread ";

    public void run() {
      for (int i = 0; i < 10; i++) {
        System.out.println(message + i);
        Task1624.sleep();
      }
    }
  }

}
