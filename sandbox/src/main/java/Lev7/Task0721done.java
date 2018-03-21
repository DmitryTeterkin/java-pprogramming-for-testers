package Lev7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Минимаксы в массивах
Создать массив на 20 чисел.
Заполнить его числами с клавиатуры.
Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.


Требования:
1. Создай массив целых чисел (int[]) на 20 элементов.
2. Считай с клавиатуры 20 целых чисел и добавь их в массив.
3. Найди и выведи через пробел максимальное и минимальное числа.
4. Используй цикл for.
 */
public class Task0721done {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int[] mas = new int[20];
    int maximum;
    int minimum;
    // наполняем массив
    for (int i = 0; i < 20; i++) {
      String s = reader.readLine();
      mas[i] = Integer.parseInt(s);
    }
    // ищем максимум и минимум
    maximum = mas[0]; minimum = mas[0];
    for (int i = 0; i < mas.length; i++) {
      if (mas[i] > maximum){
        maximum = mas[i];
      }
      if (mas[i] < minimum){
        minimum = mas[i];
      }
    }
   // выводим результат поиска
   System.out.print(maximum + " " + minimum);
  }
}
