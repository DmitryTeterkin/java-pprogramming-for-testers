package Lev15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*
Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14

http://javarush.ru/alpha/index.html?obj=3fgfg.14&name=Amigo

Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Класс Solution не должен содержать статические поля.
3. Программа должна выводить данные на экран в соответствии с условием.
4. Программа должна вызывать метод alert с параметром double в случае, если значение параметра obj может быть корректно преобразовано в число типа double.
5. Программа должна вызывать метод alert с параметром String в случае, если значение параметра obj НЕ может быть корректно преобразовано в число типа double.
 */
public class Task1527 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String url = reader.readLine();
    reader.close();
    int indexOfQestion = url.indexOf("?");
    String parameters = url.substring(indexOfQestion + 1);
    ArrayList<String> List = new ArrayList<String>();
    int j = 0;
    HashMap<String, String> P = new HashMap<>();
    // парсим строчку с параметрами на части параметр + значение.
    if (parameters.contains("&")) {
      StringBuilder s = new StringBuilder();
      char params[] = parameters.toCharArray();
      for (int i = 0; i < params.length; i++) {
        if (params[i] != Character.valueOf('&')) {
          s.append(params[i]);
        } else {
          List.add(j, s.toString());
          s = new StringBuilder();
          j++;
        }
      }
      List.add(j, s.toString());
    } else {
      List.add(j, parameters);
    }
    // делим параметры на значения и добавляем их в MAP параметр + значение, и сразу выводим на печать.
    for (int i = 0; i < List.size(); i++) {
      if (List.get(i).contains("=")) {
        int indexOfEqals = List.get(i).indexOf("=");
        String key = List.get(i).substring(0, indexOfEqals);
        String value = List.get(i).substring(indexOfEqals + 1);
        System.out.print(key + " ");
        P.put(key, value);
      } else {
        P.put(List.get(i), "");
        System.out.print(List.get(i) + " ");
      }
    }
    System.out.println();
    // проверяем наличие паарметра obj и вызываем соответствующий метод alert
    for (HashMap.Entry<String, String> pair : P.entrySet()) {
      if (pair.getKey().equals("obj")) {
        try {
          alert(Double.parseDouble(pair.getValue()));
        } catch (NumberFormatException e) {
          alert(pair.getValue());
        }
      }
      //System.out.print(pair.getKey() + " ");
    }
  }

  public static void alert(double value) {
    System.out.println("double " + value);
  }

  public static void alert(String value) {
    System.out.println("String " + value);
  }
}
