package JavaRushExercises.Lev4;

import java.util.Scanner;
/*
18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись "Подрасти еще".


Требования:
1. Программа должна дважды считать данные c клавиатуры.
2. Программа должна использовать команду System.out.println() или System.out.print().
3. Если возраст меньше 18 вывести только сообщение "Подрасти еще".
4. Если возраст больше либо равно 18 ничего не выводить.
 */
public class AgeCheck {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    String name1 = scanner.next();
    String age = scanner.next();
    int a = Integer.parseInt(age);

    if (a < 18) {
      System.out.println("Подрасти еще");
    }
  }
}
