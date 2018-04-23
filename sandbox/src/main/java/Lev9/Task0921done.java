package Lev9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Написать программу, которая будет вводить числа с клавиатуры.
Код по чтению чисел с клавиатуры должен быть в методе readData.
Код внутри readData обернуть в try..catch.
Если пользователь ввёл какой-то текст, вместо ввода числа, то метод должен перехватить исключение и вывести на экран
 все ранее введенные числа в качестве результата.
Числа выводить с новой строки сохраняя порядок ввода.


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Метод main не изменять.
3. Метод main не должен кидать исключений.
4. Метод readData должен содержать блок try..catch.
5. Если пользователь ввел текст, а не число, программа должна вывести все ранее введенные числа.
 */
public class Task0921done {
  public static void main(String[] args) {
    readData();
  }

  public static void readData() {
    ArrayList<Integer> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      try {
        String s = reader.readLine();
        list.add(Integer.parseInt(s));
      } catch (NumberFormatException e) {
        for (int i = 0; i < list.size(); i++) {
          System.out.println(list.get(i));
        }
        break;
      }catch (IOException e){break;}
    }
  }
}
