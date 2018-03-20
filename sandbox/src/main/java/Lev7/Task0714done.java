package Lev7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Слова в обратном порядке
Введи с клавиатуры 5 слов в список строк. Удали 3 - ий элемент списка, и выведи оставшиеся элементы в обратном порядке.


Требования:
1. Объяви переменную типа ArrayList (список строк) и сразу проинициализируй ee.
2. Считай 5 строк с клавиатуры и добавь их в список.
3. Удали третий элемент массива.
4. Выведи элементы на экран, каждый с новой строки.
5. Порядок вывода должен быть обратный.
 */
public class Task0714done {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < 5; i++) {
      list.add(i, reader.readLine());
    }
    list.remove(2);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(list.size()-i-1));
    }
  }
}
