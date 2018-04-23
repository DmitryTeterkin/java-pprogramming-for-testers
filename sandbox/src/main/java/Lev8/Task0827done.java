package Lev8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года
- нечетное число, иначе false
2. String date передается в формате FEBRUARY 1 2013
Не забудьте учесть первый день года.

Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false


Требования:
1. Программа должна выводить текст на экран.
2. Класс Task0925done должен содержать два метода.
3. Метод isDateOdd() должен возвращать true, если количество дней с начала года - нечетное число, иначе false.
4. Метод main() должен вызывать метод isDateOdd().
 */

public class Task0827done {
  public static void main(String[] args) throws ParseException {
    System.out.println(isDateOdd("JANUARY 31 2000"));


  }

  public static boolean isDateOdd(String date) throws ParseException {

    Date date1 = new Date(date);
    SimpleDateFormat df = new SimpleDateFormat("D");
    int day = Integer.parseInt(df.format(date1));
    System.out.println(day);
    if (day % 2 != 0){
      return true;
    } else {
      return false;
    }
  }

}
