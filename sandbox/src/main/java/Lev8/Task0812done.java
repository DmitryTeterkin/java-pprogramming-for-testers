package Lev8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/*
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 9, 12, 12, 14:
3

Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел
состоит из трех четверок.


Требования:
1. Программа должна выводить число на экран.
2. Программа должна считывать значения с клавиатуры.
3. В методе main объяви переменную типа ArrayList с типом элементов Integer и сразу
проинициализируй ee.
4. Программа должна добавлять в коллекцию 10 чисел, согласно условию.
5. Программа должна выводить на экран длину самой длинной последовательности повторяющихся
чисел в списке.
 */
public class Task0812done {
  public static void main(String[] args) throws IOException {

    ArrayList<Integer> list = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int num = 0,  max = 1, count = 0;
    for (int i = 0; i < 10; i++) {
      String s = reader.readLine();
      list.add(Integer.parseInt(s));
    }

    for (Integer aList : list) {
      if (num == aList) {
        count++;
        if (count > max) {
          max = count;
        }
      } else {
        num = aList;
        count = 1;
      }
    }
    System.out.println(max);
  }

}
