package Lev6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Imt {
/*
Контролируем массу тела
Программа должна считывать введенные пользователем вес в килограммах и рост в метрах и выводить на экран сообщение о индексе массы тела.
Реализуй статический метод класса Body. Метод должен определить индекс массы тела, и вывести на экран сообщение:
"Недовес: меньше чем 18.5" - если индекс массы тела меньше 18.5,
"Нормальный: между 18.5 и 24.9" - если индекс массы тела между 18.5 и 24.9,
"Избыточный вес: между 25 и 29.9" - если индекс массы тела между 25 и 29.9,
"Ожирение: 30 или больше" - если индекс массы тела 30 или больше.

Подсказка:
Индекс массы тела = вес в кг / (рост в метрах * рост в метрах)

Пример вывода для 68.4 и 1.77:
Нормальный: между 18.5 и 24.9

*/



    public static void main(String[] args) throws IOException {
      BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
      double weight = Double.parseDouble(bis.readLine());
      double height = Double.parseDouble(bis.readLine());

      Body.massIndex(weight, height);
    }

    public static class Body {
      public static void massIndex(double weight, double height) {
        Double imt = weight/(height*height);
        if (imt < 18.5){System.out.println("Недовес: меньше чем 18.5");}
        if (imt >= 18.5 && imt <= 24.9){System.out.println("Нормальный: между 18.5 и 24.9");}
        if (imt >= 25.0 && imt <= 29.9){System.out.println("Избыточный вес: между 25 и 29.9");}
        if (imt > 30.0){System.out.println("Ожирение: 30 или больше");}
      }
    }
  }
