package JavaRushExercises.Lev4;

import java.util.Scanner;

/*
Положительное число
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.

Примеры:
а) при вводе чисел
-4
6
6
получим вывод
2

б) при вводе чисел
-6
-6
-3
получим вывод
0

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить количество положительных чисел в исходном наборе.
4. Если положительных чисел нет, программа должна вывести "0".
 */
public class CountPlusNumbers {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] mas = new int[3];
    mas[0] = scanner.nextInt();
    mas[1] = scanner.nextInt();
    mas[2] = scanner.nextInt();
    int pol = 0;
    for (int i = 0; i < 3; i++) {
      if (mas[i] > 0) {
        pol = pol + 1;
      }
    }
    System.out.println(pol);
  }
}