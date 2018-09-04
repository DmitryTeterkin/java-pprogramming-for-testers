package Lev14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.


Требования:
1. Программа должна считывать с клавиатуры 2 строки.
2. В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных с клавиатуры и успешно завершаться.
 */
public class Task1420ready {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int a = 0, b = 0;
    try {
      a = Integer.parseInt(reader.readLine());
    } catch (Exception e) {
      //System.out.println(e);
    }
    try {
      b = Integer.parseInt(reader.readLine());
    } catch (Exception e) {
    //  System.out.println(e);
    }
    reader.close();
    if (a > 0 & b > 0) {
      while (a != b) {
        if (a > b) {
          a = a - b;
        } else {
          b = b - a;
        }
      }
      System.out.println(a);
    }
  }
}
