package Lev16;

import java.util.ArrayList;
import java.util.List;

/*
Список и нити
В методе main добавить в статический объект list 5 нитей. Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.


Требования:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Метод run класса SpecialThread должен выводить "it's a run method inside SpecialThread".
 */
public class Task1603done {
  public static volatile List<Thread> list = new ArrayList<Thread>(5);

  public static void main(String[] args) {
    SpecialThread s1 = new SpecialThread();
    Thread t1 = new Thread(s1);
    SpecialThread s2 = new SpecialThread();
    Thread t2 = new Thread(s2);
    SpecialThread s3 = new SpecialThread();
    Thread t3 = new Thread(s3);
    SpecialThread s4 = new SpecialThread();
    Thread t4 = new Thread(s4);
    SpecialThread s5 = new SpecialThread();
    Thread t5 = new Thread(s5);
    list.add(t1);
    list.add(t2);
    list.add(t3);
    list.add(t4);
    list.add(t5);
  }

  public static class SpecialThread implements Runnable {
    public void run() {
      System.out.println("it's a run method inside SpecialThread");
    }
  }

}
