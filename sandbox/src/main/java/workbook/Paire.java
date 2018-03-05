package workbook;

import java.util.Scanner;

public class Paire {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    if (a==b && b==c){
      System.out.println(a + " "+ b +" "+ c);
    } else if (a==b) {
      System.out.println(a + " " + b);
    } else if (a==c){
      System.out.println(a + " " + c);
    } else if (b == c) {
      System.out.println(b + " " + c);
    }
  }
}
/*
Существует ли пара?
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел.
Если все три числа равны между собой, то вывести все три.

Примеры:
а) при вводе чисел
1
2
2
получим вывод
2 2

б) при вводе чисел
2
2
2
получим вывод
2 2 2

 */