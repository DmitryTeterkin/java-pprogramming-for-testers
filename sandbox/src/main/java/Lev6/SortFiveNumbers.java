package Lev6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortFiveNumbers {
  /* Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.

   Пример ввода:
           3
           2
           15
           6
           17

   Пример вывода:
           2
           3
           6
           15
           17


   Требования:
           1. Программа должна считывать 5 чисел с клавиатуры.
 2. Программа должна выводить 5 чисел, каждое с новой строки.
           3. Выведенные числа должны быть отсортированы по возрастанию.
 4. Вывод должен содержать те же числа, что и были введены (порядок не важен).

          сделано!!
           */
  public static void main(String[] args) throws IOException {
    int[] mas = new int[5];
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 5; i++){
    mas[i] = Integer.parseInt((reader.readLine()));}

    for (int j = 0; j < 4; j++) {
      for (int i = 0; i < 4; i++) {
        if (mas[i] > mas[i + 1]) {
          int min = mas[i + 1];
          mas[i+1] = mas[i];
          mas[i] = min;
        }
      }
    }
for (int i = 0; i<5; i++){
  System.out.println(mas[i]);
}
  }
}
