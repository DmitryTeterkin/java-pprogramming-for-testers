package Lev04;

import java.util.Scanner;

/*
Письмо счастья
Ввести с клавиатуры имя и используя цикл for 10 раз вывести: "*имя* любит меня."

Пример вывода на экран для имени Света:
Света любит меня.
Света любит меня.
Света любит меня.
Света любит меня.
Света любит меня.
Света любит меня.
Света любит меня.
Света любит меня.
Света любит меня.
Света любит меня.


Требования:
1. Программа должна считывать имя c клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна выводить 10 раз текст указанный в задании.
4. В программе должен использоваться цикл for.
 */
public class HappinessLetter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String name1 = scanner.next();
    for (int i = 0; i < 10; i++){
      System.out.println(name1 + " любит меня.");
    }
  }
}