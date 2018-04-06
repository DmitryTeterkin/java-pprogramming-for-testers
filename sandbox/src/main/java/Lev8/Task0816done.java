package Lev8;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
 */
public class Task0816done {

    public static HashMap<String, Date> createMap() {
      HashMap<String, Date> map = new HashMap<String, Date>();
      map.put("Stallone", new Date("January 1 1980"));
      map.put("Stella", new Date("February 1 1980"));
      map.put("Suzana", new Date("March 1 1980"));
      map.put("Denchik", new Date("April 1 1980"));
      map.put("Russy", new Date("May 5 1980"));
      map.put("Pups", new Date("June 1 1980"));
      map.put("Euzana", new Date("July 1 1980"));
      map.put("Tenchik", new Date("August 1 1980"));
      map.put("Yussy", new Date("September 1 1980"));
      map.put("Uups", new Date("October 1 1980"));


      return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {

      Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
      int month;
      Map.Entry<String, Date> pair;
      while (iterator.hasNext()){
        pair = iterator.next();
        month = pair.getValue().getMonth();
        if (month > 4 && month < 8){
          iterator.remove();
        }
      }
    }

    public static void main(String[] args) {
      HashMap<String, Date> map = createMap();
      removeAllSummerPeople(map);

    }
}

