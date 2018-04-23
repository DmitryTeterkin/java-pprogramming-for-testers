package Lev8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:

Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Task0925done должен содержать один метод.
4. Программа должна вывести фамилию семьи по введенному городу.
 */
public class Task0829done {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //list of addresses
    List<String> addresses = new ArrayList<String>();
    while (true) {
      String family = reader.readLine();
      if (family.isEmpty()) break;

      addresses.add(family);
    }

    //read home number
    String city = reader.readLine();

    if (addresses.contains(city))
      System.out.println(addresses.get(addresses.indexOf(city) + 1));

  }

}
