package JavaRushExercises.Lev4;
/*
Настя или Настя?
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение "Имена идентичны".
Если имена разные, но их длины равны - вывести сообщение - "Длины имен равны".
Если имена и длины имен разные - ничего не выводить.


Требования:
1. Программа должна считывать две строки c клавиатуры.
2. Программа должна содержать System.out.println() или System.out.print()
3. Если имена одинаковые вывести сообщение "Имена идентичны"
4. Если имена разные, но их длины равны , вывести сообщение "Длины имен равны"
5. Если имена и длины имен разные - ничего не выводить.
 */

import java.util.Scanner;

public class TwoStringsComparing {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    String name1 = scanner.next();
    String name2 = scanner.next();
    int a, b;
    a = name1.length();
    b = name2.length();
    if (name1.equals(name2)) {
      System.out.println("Имена идентичны");
    } else if (a == b) {
      System.out.println("Длины имен равны");
    }
  }
}