package Lev07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 5 строк с клавиатуры и записывать их в список.
3. Программа должна выводить самую короткую строку на экран.
4. Если есть несколько строк с длиной равной минимальной, то нужно вывести каждую из них с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       ArrayList<String> List = new ArrayList<String>();
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int min = Integer.MAX_VALUE;
       for (int i = 0; i < 5; i++){
           String s = reader.readLine();
           List.add(s);
           if (s.length() < min){
               min = s.length();
           }
       }
       for (int i = 0; i < List.size(); i++){
           String s = List.get(i);
           if (s.length() ==min){
               System.out.println(s);
           }
       }
    }
}
