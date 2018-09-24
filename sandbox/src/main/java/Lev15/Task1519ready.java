package Lev15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. меньше либо равно нулю или больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна прекращать считывать данные с клавиатуры после того, как была введена строка "exit".
3. Если введенная строка содержит точку(".") и может быть корректно преобразована в число типа Double -
      должен быть вызван метод print(Double value).
4. Если введенная строка может быть корректно преобразована в число типа short и полученное число больше 0,
      но меньше 128 - должен быть вызван метод print(short value).
5. Если введенная строка может быть корректно преобразована в число типа Integer и полученное число меньше или равно
      0 или больше или равно 128 - должен быть вызван метод print(Integer value).
6. Во всех остальных случаях должен быть вызван метод print(String value). */
public class Task1519ready {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    boolean t = true;
    boolean a = false;
    while (t) {
      String s = reader.readLine();
      if (!s.equals("exit")) {
        char[] mas = s.toCharArray();
        for (int i = 0; i < mas.length; i++) {
          if (mas[i] == '.') {
            a = true;
          }
        }
        if (a) {
          try {
            double d = Double.parseDouble(s);
            print(d);
            a = false;
          } catch (NumberFormatException eDouble) {
            print(s);
            a = false;
          }
        } else try {
          int iN = Integer.parseInt(s);
          if (iN >= 0 & iN <= 128) {
            short sh = Short.parseShort(s);
            print(sh);
          } else {
            if (iN <= 0 | iN >= 128) {
              print(iN);
            }
          }
        } catch (NumberFormatException eInt) {
          print(s);
        }
      } else {
        reader.close();
        t = false;
      }
    }
  }


  public static void print(Double value) {
    System.out.println("Это тип Double, значение " + value);
  }

  public static void print(String value) {
    System.out.println("Это тип String, значение " + value);
  }

  public static void print(short value) {
    System.out.println("Это тип short, значение " + value);
  }

  public static void print(Integer value) {
    System.out.println("Это тип Integer, значение " + value);
  }
}
