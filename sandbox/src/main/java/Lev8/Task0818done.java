package Lev8;

import java.util.HashMap;
import java.util.Map;

/*
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: "фамилия" - "зарплата".
Удалить из словаря всех людей, у которых зарплата ниже 500.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Task0925done должен содержать только три метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Integer
состоящих из 10 записей по принципу «фамилия» - «зарплата».
5. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.

 Сделано!!!!

 */
public class Task0818done {
 public static HashMap<String, Integer> createMap() {
   HashMap<String, Integer> map = new HashMap<String, Integer>();
   map.put("иванов",100);
   map.put("петров",600);
   map.put("степанов",450);
   map.put("новиков",500);
   map.put("сидоров",240);
   map.put("кузькин",1000);
   map.put("васнецов",600);
   map.put("петрович",850);
   map.put("иванович",100);
   map.put("ивановский",230);
   return map;
  }

  public static void removeItemFromMap(HashMap<String, Integer> map) {
    HashMap<String, Integer> copy = new HashMap<String, Integer>(map);
    for (Map.Entry<String, Integer> pair : copy.entrySet()) {
      if (pair.getValue() < 500) {
        map.remove(pair.getKey());
      }
    }
  }

  public static void main(String[] args) {
    HashMap<String, Integer> map = createMap();
    removeItemFromMap(map);
    System.out.println(map);
 }

}
