package Lev07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
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
