package Lev07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.


Требования:
1. Инициализируй поле класса новым ArrayList<>
2. Программа должна считывать 5 строк с клавиатуры и записывать их в список strings.
3. Программа должна выводить самую длинную строку на экран.
4. Если есть несколько строк с длиной равной максимальной, то нужно вывести каждую из них с новой строки.
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
       strings = new ArrayList<String>();
       int max = -1;
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       for (int i = 0; i < 5; i++) {
           String s = reader.readLine();
           strings.add(s);
           int l = s.length();
           if (l > max) {
               max = l;
           }
       }
          for (int i = 0; i < strings.size(); i++ ){
           String s = strings.get(i);
           if (s.length() == max){
               System.out.println(strings.get(i));
           }
          }


    }
}
