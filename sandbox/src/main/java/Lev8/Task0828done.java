package Lev8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: "May is 5 month".
Используйте коллекции.


Требования:
1. Программа должна считывать одно значение с клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна использовать коллекции.
4. Программа должна считывать с клавиатуры имя месяца и выводить его номер на экран по заданному шаблону.

 сделано!!!!!!!!
 */
public class Task0828done {
  public static void main(String[] args) throws IOException {
    HashMap<String, Integer> monthes = new HashMap<String, Integer>();
    monthes.put("January", 1);
    monthes.put("February", 2);
    monthes.put("March", 3);
    monthes.put("April", 4);
    monthes.put("May", 5);
    monthes.put("June", 6);
    monthes.put("July", 7);
    monthes.put("August", 8);
    monthes.put("September", 9);
    monthes.put("October", 10);
    monthes.put("November", 11);
    monthes.put("December", 12);

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String month = reader.readLine();
    for (HashMap.Entry<String, Integer> pair : monthes.entrySet() ) {
      if (pair.getKey().equals(month))
        System.out.println(month +" is " + pair.getValue() + " month");
    }
  }
}
