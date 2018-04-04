package Lev8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь
HashMap с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.

 сделано!!!!
 */
public class Task0815done {
  public static HashMap<String, String> createMap() {
   HashMap<String, String> map = new HashMap<String, String>();
    map.put("Иванов","иван");
    map.put("Семенов","петр");
    map.put("Петров","иван");
    map.put("Иванов1","дима");
    map.put("Сидоров","андрей");
    map.put("Иванов2","иван");
    map.put("Синицин","андрей");
    map.put("Петров3","петр");
    map.put("Сидоров4","иван");
    map.put("Иванов5","дима");
    System.out.println(map);
   return map;
  }

  public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
    int countSameName = 0;
    Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, String> pair = iterator.next();
      // String key = pair.getKey();
      String n = pair.getValue();
      if (n.equals(name)) {
        countSameName = countSameName + 1;
      }
    }
   // System.out.println(countSameName);
    return countSameName;
  }

  public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
    int countSameName = 0;
    Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, String> pair = iterator.next();
      String key = pair.getKey();
      String n = pair.getValue();
      if (key.equals(lastName)) {
        countSameName = countSameName + 1;
      }
    }
  //  System.out.println(countSameName);
    return countSameName;
  }

  public static void main(String[] args) {
   HashMap<String, String> map = createMap();
   getCountTheSameFirstName(map, "иван");
   getCountTheSameLastName(map, "Иванов");
  }

}
