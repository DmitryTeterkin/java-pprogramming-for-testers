package Lev7;
/*
Удваиваем слова
1. Введи с клавиатуры 10 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. Выведи результат на экран, каждое значение с новой строки.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай 10 строк с клавиатуры и добавь их в список.
3. Метод doubleValues должен удваивать элементы списка по принципу a,b,c -> a,a,b,b,c,c..
4. Выведи получившийся список на экран, каждый элемент с новой строки.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task0717done {

    public static void main (String[]args) throws Exception {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      ArrayList<String> list = new ArrayList<String>();
      // заполняем список
      for (int i = 0; i < 10; i++) {
        list.add(i, reader.readLine());
      }

      ArrayList<String> result = doubleValues(list);

      for (int i = 0; i < result.size(); i++) {
        System.out.println(result.get(i));
      }

    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
      for (int i = 0; i < list.size(); i++){
        if (i % 2 == 0){
          list.add(i+1, list.get(i));
        }
      }
      return list;
    }

}
