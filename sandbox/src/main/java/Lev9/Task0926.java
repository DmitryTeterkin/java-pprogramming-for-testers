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
public class Task0926 {
  public static void main(String[] args) {
    ArrayList<int[]> list = createList();
    printList(list);
  }

  public static ArrayList<int[]> createList() {
    //напишите тут ваш код
    return null; //!!!!!!!!!!!!!!!!!
  }

  public static void printList(ArrayList<int[]> list) {
    for (int[] array : list) {
      for (int x : array) {
        System.out.println(x);
      }
    }
  }
}
