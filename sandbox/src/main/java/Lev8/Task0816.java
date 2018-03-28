package Lev8;

import java.util.Date;
import java.util.HashMap;

/*
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
 */
public class Task0816 {
  public static HashMap<String, Date> createMap() {
    HashMap<String, Date> map = new HashMap<String, Date>();
    map.put("Stallone", new Date("JUNE 1 1980"));

    //напишите тут ваш код
  }

  public static void removeAllSummerPeople(HashMap<String, Date> map) {
    //напишите тут ваш код

  }

  public static void main(String[] args) {

  }
}
