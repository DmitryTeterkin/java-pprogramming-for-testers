package JavaRushExercises.Lev4;
/*
Хорошего много не бывает
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while. Каждое значение с новой строки.

Пример ввода:
абв
2

Пример вывода:
абв
абв


Требования:
1. Программа должна считывать текст c клавиатуры.
2. Программа должна выводить текст на экран.
3. Каждое значение должно быть выведено с новой строки.
4. Программа должна выводить на экран строку N раз.
5. В программе должен использоваться цикл while.
 */

import java.util.Scanner;

public class StrokaNRaz {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String Str = scanner.next();
    String count = scanner.next();
    int a = Integer.parseInt(count);
    int i = 0;
    if (a > i) {
      while (i != a) {
        System.out.println(Str);
        i = i + 1;
      }
    }
  }
}
