package Lev8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
3. Класс Solution должен содержать один метод.
4. Программа должна заменять в тексте первые буквы всех слов на заглавные.

заебало!!!! нужен 1 метод, нужно учитывать несколько пробелов между словами.

 */
public class Task0823ready {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s = reader.readLine(); // считываем строку
    String[] subStr; // объявляем массив слов
    String delimeter = " "; // указываем разделитель между словами
    subStr = s.split(delimeter); // преобразуем строку в массив слов
    makeZagl(subStr); // метод изменения первой буквы на заглавную
    s = subStr[0]; // собираем строку обратно
    for (int i = 1; i < subStr.length; i++) {
     s = s + " " + subStr[i];
    }
    System.out.println(s); // выводим строку на печать
  }

  // метод изменения каждого слова из массива
  public static void makeZagl(String[] subStr) {
    for (int i = 0; i < subStr.length; i++) {
      subStr[i] = toZagl(subStr[i]); // метод преобразования буквы в заглавную
    }
  }
// получаем слово и преобразуем его в массив букв. проверяем, если буква не заглавная, то заменяем на заглавную,
// склеиваем обратно в слово и возвращаем его
  public static String toZagl(String s) {
    char[] simb = s.toCharArray();
    if (Character.isLowerCase(simb[0])){
      simb[0] = Character.toUpperCase(simb[0]);
     // System.out.println(simb[0]);
    }
    String newS = "";
    for (int i = 0; i < simb.length; i++) {
    String sl = String.valueOf(simb[i]);

    newS = newS + sl;
    }
    //System.out.println(newS);
    return newS;
  }

}
