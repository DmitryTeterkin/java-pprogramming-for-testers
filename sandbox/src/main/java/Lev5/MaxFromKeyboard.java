package Lev5;
/*
        Написать программу, которая:
        1. считывает с консоли число N, которое должно быть больше 0
        2. потом считывает N чисел с консоли
        3. выводит на экран максимальное из введенных N чисел.


        Требования:
        1. Программа должна считывать числа с клавиатуры.
        2. В классе должен быть метод public static void main.
        3. Нельзя добавлять новые методы в класс Task0925done.
        4. Программа должна выводить на экран максимальное из введенных N чисел.
        */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxFromKeyboard {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int quantity = Integer.parseInt((reader.readLine()));
    if (quantity > 0) {
      int[] a = new int[quantity];
      int maximum = Integer.MIN_VALUE;
      for (int i = 0; i < quantity; i++) {
        a[i] = Integer.parseInt((reader.readLine()));
        if (maximum < a[i]){maximum = a[i];}//напишите тут ваш код
      }
      System.out.println(maximum);
    }
  }

}
