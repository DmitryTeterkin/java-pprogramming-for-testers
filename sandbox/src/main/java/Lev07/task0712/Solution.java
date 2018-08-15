package Lev07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 

Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
3. Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
4. Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedreader = new BufferedReader (new InputStreamReader(System.in));
        int max = -1;
        int min = Integer.MAX_VALUE;
        int posMin = 0;
        int posMax = 0;
        ArrayList<String> strings = new ArrayList();

        for (int i = 0; i < 10; i++){
            String s = bufferedreader.readLine();
            strings.add(s);
            if (max < s.length()){
                max = s.length();
                posMax = i;
            }
            if (s.length() < min){
                min = s.length();
                posMin = i;
            }
        }
        if (posMax < posMin){
        System.out.println(strings.get(posMax));
        } else{
            System.out.println(strings.get(posMin));
        }
    }
}
