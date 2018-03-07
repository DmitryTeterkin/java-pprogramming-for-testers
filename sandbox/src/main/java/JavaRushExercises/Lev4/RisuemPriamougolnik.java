package JavaRushExercises.Lev4;

import java.util.Scanner;

/*
Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.

Пример: m=2, n=4
8888
8888


Требования:
1. Программа должна считывать два числа c клавиатуры.
2. Программа должна выводить числа на экран.
3. Программа должна выводить прямоугольник размером m на n из восьмёрок.
4. В программе должен использоваться цикл for.
 */
public class RisuemPriamougolnik {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    for (int i = 0; i < m; i++){
      for (int j = 0; j < n; j++){
        System.out.print("8");
      }
      System.out.println();
    }
  }
}
