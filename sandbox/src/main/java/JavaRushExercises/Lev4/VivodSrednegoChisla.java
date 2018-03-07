package JavaRushExercises.Lev4;

import java.util.Scanner;
/*
Как-то средненько
Ввести с клавиатуры три числа, вывести на экран среднее из них.
Т.е. не самое большое и не самое маленькое.
Если все числа равны, вывести любое из них.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить среднее из трех чисел.
4. Если все числа равны, вывести любое из них.
5. Если два числа из трех равны, вывести любое из двух.
 */
public class VivodSrednegoChisla {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] mas = new int[3];
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
    System.out.println(mas[1]);
  }
}
