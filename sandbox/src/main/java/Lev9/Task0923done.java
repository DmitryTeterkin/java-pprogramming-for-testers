package Lev9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы из введённой строки.
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
Пример ввода:
Мама мыла раму.

Пример вывода:
а а ы а а у
М м м л р м .


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить две строки.
3. Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
4.  Вторая строка должна содержать только согласные и знаки препинания из введенной строки, разделенные пробелом.
5. Каждая строка должна заканчиваться пробелом.
 */
public class Task0923done {
  public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

  public static void main(String[] args) throws Exception {
    ArrayList<Character> vowel = new ArrayList<Character>();
    ArrayList<Character> novowel = new ArrayList<Character>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //напишите тут ваш код
    String s = reader.readLine();
    char[] stroka = s.toCharArray();
    for (int i = 0; i < stroka.length; i++) {
      String l = String.valueOf(stroka[i]);
      if (isVowel(stroka[i])) {
        vowel.add(stroka[i]);
      } else { if (!l.equals(" ")) {
        novowel.add(stroka[i]);
      }
      }
    }
    for (int i = 0; i < vowel.size(); i++) {
      System.out.print(vowel.get(i) + " ");
    }
    System.out.println();
    for (int i = 0; i < novowel.size(); i++) {
      System.out.print(novowel.get(i) + " ");
    }
  }

  // метод проверяет, гласная ли буква
  public static boolean isVowel(char c) {
    c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

    for (char d : vowels)   // ищем среди массива гласных
    {
      if (c == d)
        return true;
    }
    return false;
  }

}
