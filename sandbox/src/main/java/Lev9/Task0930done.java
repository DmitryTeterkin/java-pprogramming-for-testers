package Lev9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Задача: Пользователь вводит с клавиатуры список слов (и чисел).
Слова вывести в возрастающем порядке, числа - в убывающем.

Пример ввода:
Вишня
1
Боб
3
Яблоко
22
0
Арбуз

Пример вывода:
Арбуз
22
Боб
3
Вишня
1
0
Яблоко


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить данные на экран.
3. Выведенные слова должны быть упорядочены по возрастанию.
4. Выведенные числа должны быть упорядочены по убыванию.
5. Метод main должен использовать метод sort.
6. Метод sort должен использовать метод isGreaterThan.
7. Метод sort должен использовать метод isNumber.
 */
public class Task0930done {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> list = new ArrayList<String>();
    while (true) {
      String s = reader.readLine();
      if (s.isEmpty()) break;
      list.add(s);
    }

    String[] array = list.toArray(new String[list.size()]);
    sort(array);

    for (String x : array) {
      System.out.println(x);
    }
  }

  public static void sort(String[] array) {
    // распихиваем слова и цифры по двум массивам.
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    ArrayList<String> words = new ArrayList<String>();
    for (int i = 0; i < array.length; i++) {
      if (isNumber(array[i])) {
        numbers.add(Integer.parseInt(array[i]));
      } else {
        words.add(array[i]);
      }
    }

    // сортируем массивы слов и цифр
     Collections.sort(numbers);
//    Collections.sort(words);

    for (int j = 0; j < words.size()-1; j++) {
      for (int i = 0; i < words.size()-1; i++) {
        if (isGreaterThan(words.get(i), words.get(i+1))) {
          String min = words.get(i+1);
          words.set(i+1,words.get(i));
          words.set(i, min);
        }
      }
    }
   // System.out.println(words);
    // пихаем в исходный массив отсортированные слова и цифры в заданном порядке
    int n = 0, m = numbers.size()-1;
    for (int i = 0; i < array.length; i++) {
      if (isNumber(array[i])){
        String s = String.valueOf(numbers.get(m));
        array[i] = s;
       m--;
      } else{
        array[i] = words.get(n);
        n++;
      }
    }

   // String a = "", b = "";
   // isGreaterThan(a, b);
  }

  // Метод для сравнения строк: 'а' больше чем 'b'
  public static boolean isGreaterThan(String a, String b) {
    return a.compareTo(b) > 0;
  }


  // Переданная строка - это число?
  public static boolean isNumber(String s) {
    if (s.length() == 0) return false;

    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if ((i != 0 && c == '-') // есть '-' внутри строки
              || (!Character.isDigit(c) && c != '-') // не цифра и не начинается с '-'
              || (i == 0 && c == '-' && chars.length == 1)) // не '-'
      {
        return false;
      }
    }
    return true;
  }
}
