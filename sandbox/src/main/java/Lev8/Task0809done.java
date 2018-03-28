package Lev8;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/*

Измерить, сколько времени занимает 10 тысяч вставок для каждого списка.
Метод getTimeMsOfInsert должен вернуть время своего исполнения в миллисекундах.


Требования:
1. Программа должна выводить числа на экран.
2. Метод main должен вызывать метод getTimeMsOfInsert только два раза.
3. Метод insert10000(List list) должен вставлять 10 тысяч элементов в список.
4. Метод getTimeMsOfInsert должен вызывать метод insert10000 только один раз.
5. Метод getTimeMsOfInsert должен вернуть время в миллисекундах, которое занимает 10 тысяч вставок в список.
 */
public class Task0809done {
  public static void main(String[] args) {
    System.out.println(getTimeMsOfInsert(new ArrayList()));
    System.out.println(getTimeMsOfInsert(new LinkedList()));
  }

  public static long getTimeMsOfInsert(List list) {
    long time = 0;
    Date before = new Date();
    insert10000(list);
    Date after = new Date();
   time = after.getTime() - before.getTime();
   return time;
  }

  public static void insert10000(List list) {
    for (int i = 0; i < 10000; i++) {
      list.add(0, new Object());
    }
  }
}
