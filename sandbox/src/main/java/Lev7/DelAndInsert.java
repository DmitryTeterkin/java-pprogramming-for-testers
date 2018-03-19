package Lev7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DelAndInsert {
/*
Удалить и вставить
1. Создай список строк.
2. Добавь в него 5 строк с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 5 строк с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Программа должна выводить список на экран, каждое значение с новой строки.
*/


    public static void main(String[] args) throws Exception {
      BufferedReader bufferedreader = new BufferedReader (new InputStreamReader(System.in));
      ArrayList<String> strings = new ArrayList();

      for (int i = 0; i < 5; i++){
        strings.add(bufferedreader.readLine());
      }
      for (int i = 0; i < 13; i++){
        strings.add(0, strings.remove(4));
      }

      for (int i = 0; i < 5; i++)
        System.out.println(strings.get(i));
    }
}