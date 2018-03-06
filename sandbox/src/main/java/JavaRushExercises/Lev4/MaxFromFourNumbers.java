package JavaRushExercises.Lev4;

/*
Максимум четырех чисел
        Ввести с клавиатуры четыре числа, и вывести максимальное из них.
        Если числа равны между собой, необходимо вывести любое.


        Требования:
        1. Программа должна считывать числа c клавиатуры.
        2. Программа должна выводить число на экран.
        3. Программа должна выводить на экран максимальное из четырёх чисел.
        4. Если максимальных чисел несколько, необходимо вывести любое из них.
*/

import java.util.Scanner;

public class MaxFromFourNumbers {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    int d = scanner.nextInt();
    if (comp (a,b) >= comp(c,d)){
      System.out.println(comp (a,b));
    } else System.out.println(comp(c,d));
  }

  private static int comp(int first, int second) {
    int max = 0;
    if (first>=second){
    max = first;} else max = second;
    return max;
  }

}
