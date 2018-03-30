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
public class Task0816notdon {
 public static HashMap<String, Date> createMap() {
   HashMap<String, Date> map = new HashMap<String, Date>();
   map.put("Stallone", new Date("MAY 1 1980"));
   map.put("S", new Date("NOVEMBER 1 1980"));
   map.put("St", new Date("JUNE 1 1980"));
   map.put("Sta", new Date("JUNE 1 1980"));
   map.put("Stal", new Date("JUNE 1 1980"));
   map.put("Stall", new Date("JUNE 1 1980"));
   map.put("Stallo", new Date("JUNE 1 1980"));
   map.put("Stallon", new Date("JUNE 1 1980"));
   map.put("Putin", new Date("JUNE 1 1980"));
   map.put("Putinka", new Date("JUNE 1 1980"));
   return map;
 }

  public static void removeAllSummerPeople(HashMap<String, Date> map) {


  }

  public static void main(String[] args) {
  HashMap<String, Date> map = createMap();
  removeAllSummerPeople(map);
  }

}
