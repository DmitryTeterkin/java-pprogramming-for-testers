package Lev8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
мама мыла раму.

Пример вывода:
Мама Мыла Раму.


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать строку с клавиатуры.
3. Класс Task0925done должен содержать один метод.
4. Программа должна заменять в тексте первые буквы всех слов на заглавные.

 нужен 1 метод, нужно учитывать несколько пробелов между словами.
 поправил

 */
public class Task0823done {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s = reader.readLine(); // считываем строку
    char[] stroka = s.toCharArray();
    String a = new String();
    ArrayList<String> slova = new ArrayList<String>();
    for (int i = 0; i < stroka.length; i++) {
      if (String.valueOf(stroka[i]).equals(" ")) {
        slova.add(a);
        a = "";
      } else {
        a = a + String.valueOf(stroka[i]);
      }
    }
    slova.add(a);
    slova.removeAll(Collections.singleton(""));
    s = "";
    for (int i = 0; i < slova.size(); i++) {
      char[] simb = slova.get(i).toCharArray();
      if (Character.isLowerCase(simb[0])){
        simb[0] = Character.toUpperCase(simb[0]);
      }
      String newS = "";
      for (int j = 0; j < simb.length; j++) {
        String sl = String.valueOf(simb[j]);
        newS = newS + sl;
      }
      slova.set(i, newS);
      s = s + " " + slova.get(i);
    }
    System.out.println(s);
  }
}
