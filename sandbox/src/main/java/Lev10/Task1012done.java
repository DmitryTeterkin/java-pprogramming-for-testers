package Lev10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 маленьких букв алфавита). Результат вывести на экран в алфавитном порядке.

Пример вывода:
а 5
б 8
в 3
г 7
д 0
...
я 9


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита, пробел и сколько раз буква встречалась в введенных строках.
 */
public class Task1012done {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // алфавит
    String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    char[] abcArray = abc.toCharArray();

    ArrayList<Character> alphabet = new ArrayList<Character>();
    for (int i = 0; i < abcArray.length; i++) {
      alphabet.add(abcArray[i]);
    }

    // ввод строк
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < 10; i++) {
      String s = reader.readLine();
      list.add(s.toLowerCase());
    }
  //переводим массив в строку
    String text = "";
    for (int i = 0; i < list.size(); i++) {
      text = text + list.get(i);
    }
  //переводим строку в массив букв
    char[] textchar = text.toCharArray();
    // создаем массив и считаем количество букв
    int[] count = new int[33];
    for (int i = 0; i < abcArray.length; i++) {
      for (int j = 0; j < textchar.length; j++) {
        if (textchar[j]==abcArray[i]){
          count[i] = count[i] + 1;
        }
      }
    }
    // выводим результаты подсчета на печать
    for (int i = 0; i < abcArray.length; i++) {
      System.out.println(abcArray[i] + " "+ count[i]);
    }
  }
}