package Lev7;
/*
Перестановочка подоспела
Ввести с клавиатуры 2 числа N и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.

Примечание: запрещено создавать больше одного списка.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай c клавиатуры числа N и M, считай N строк и добавь их в список.
3. Переставить M первых строк в конец списка.
4. Выведи список на экран, каждое значение с новой строки.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task0720done {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int N, M;
    ArrayList<String> list = new ArrayList<String>();
    N = Integer.parseInt(reader.readLine());
    M = Integer.parseInt(reader.readLine());
   // формируем список
    for (int i = 0; i < N; i++) {
      list.add(i, reader.readLine());
    }
    //делаем счетчик, и пока i < M брать нулевое значение и ставить в конец.
    int i = 0;
    while ( i < M) {
      String s = list.get(0);
      list.add(list.size(), s);
      list.remove(0);
      i++;
    }
    // вывод списка на экран
    for (int j = 0; j < list.size(); j++) {
      System.out.println(list.get(j));
    }
  }
}
