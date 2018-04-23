package Lev8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Создать массив на 20 чисел.
Заполнить его числами с клавиатуры.
Вывести пять наибольших чисел.
Каждое значение с новой строки.


Требования:
1. Программа должна выводить числа на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Task0925done должен содержать два метода.
4. Метод sort() должен сортировать массив чисел от большего к меньшему.
5. Метод main() должен вызывать метод sort().
6. Программа должна выводить пять наибольших чисел массива. Каждое значение с новой строки.

Сделано!!!!

 */
public class Task0826done {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int[] array = new int[20];
    for (int i = 0; i < array.length; i++) {
      array[i] = Integer.parseInt(reader.readLine());
    }

    sort(array);

    System.out.println(array[0]);
    System.out.println(array[1]);
    System.out.println(array[2]);
    System.out.println(array[3]);
    System.out.println(array[4]);
  }

  public static void sort(int[] array) {
    for (int j = 0; j < (array.length-1); j++) {
      for (int i = 0; i < (array.length-1); i++) {
        if (array[i] < array[i + 1]) {
          int max = array[i + 1];
          array[i+1] = array[i];
          array[i] = max;
        }
      }
    }
  }

}
