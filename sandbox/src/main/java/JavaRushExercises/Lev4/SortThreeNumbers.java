package JavaRushExercises.Lev4;
/*
Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
Выведенные числа должны быть разделены пробелом.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить числа на экран.
3. Выведенные числа должны быть разделены пробелом.
4. Программа должна выводить числа в порядке убывания.
 */

import java.util.Scanner;

public class SortThreeNumbers {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    // запиливаем сортировку пузырьком
    int[] mas = new int[3]; // объявляем массив 3-х чисел и заполняем его
    mas[0] = scanner.nextInt();
    mas[1] = scanner.nextInt();
    mas[2] = scanner.nextInt();
    int max = 0;
    //сортировка пузырьком :) максимальное число должно быть первым.
    for (int j = 0; j<2; j++) {
      for (int i = 0; i < 2; i++) {
        if (mas[i] < mas[i + 1]) {
          max = mas[i+1];
          mas[i+1] = mas[i];
          mas[i] = max;
        }
      }
    }
    //печатаем получившийся массив
    for (int i = 0; i < 3; i++){
      System.out.print(mas[i] + " ");
    }
  }
}
