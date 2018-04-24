package Lev9;

import java.util.ArrayList;

/*
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов-массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод createList должен объявлять и инициализировать переменную типа ArrayList.
3. Метод createList должен возвращать созданный список.
4. Метод createList должен добавлять в список 5 элементов.
5. Каждый элемент в списке должен быть массивом чисел. Длина первого должна быть 5 элементов, второго - 2, следующих - 4, 7, 0 соответственно.
6. Программа должна выводить на экран элементы всех массивов из списка. Каждый элемент с новой строки.
 */
public class Task0926done {
  public static void main(String[] args) {
    ArrayList<int[]> list = createList();
    printList(list);
  }

  public static ArrayList<int[]> createList() {
    ArrayList<int[]> newList = new ArrayList<int[]>();
    int[] a = new int[5];
    int[] b = new int[2];
    int[] c = new int[4];
    int[] d = new int[7];
    int[] e = new int[0];
    newList.add(0, a);
    newList.add(1, b);
    newList.add(2, c);
    newList.add(3, d);
    newList.add(4, e);
    for (int i = 0; i < newList.size(); i++) {
     int[] f = newList.get(i);
      for (int j = 0; j < f.length; j++) {
        f[j] = (int)(100*Math.random()+1);
      }
      newList.set(i, f);
    }
    return newList;
  }

  public static void printList(ArrayList<int[]> list) {
    for (int[] array : list) {
      for (int x : array) {
        System.out.println(x);
      }
    }
  }
}
