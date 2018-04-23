package Lev8;

import java.util.*;

/*
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Task0925done должен содержать только четыре метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, String состоящих из 10 записей.
5. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
6. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().

 надо переделать, имена должны быть одинаковые а не заданы!

  все имена, которые есть в списке проверяем на совпадение. если смя совпадает с другим - добавляем его в новый список.
  после этого запускаем еще одну проверку - если имя совпадает с новым списком - удаляем запись.
 */
public class Task0817done {
  public static HashMap<String, String> createMap() {
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("иванов", "иван");
    map.put("петров", "петр");
    map.put("степанов", "ивар");
    map.put("новиков", "ивас");
    map.put("сидоров", "иран");
    map.put("кузькин", "петр");
    map.put("васнецов", "иван");
    map.put("петрович", "изан");
    map.put("иванович", "ищан");
    map.put("ивановский", "иван");
    // System.out.println(map);
    return map;
  }

  public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
    HashSet<String> set = new HashSet<String>();
    Iterator<HashMap.Entry<String, String>> iterator = map.entrySet().iterator();
    ArrayList<String> values = new ArrayList<>();
    Set<String> duplicates = new HashSet<>();
    // выбираем имена в отдельный массив
    while (iterator.hasNext()) {
      HashMap.Entry<String, String> pair = iterator.next();
      String value = pair.getValue();
      //System.out.println(value);
      values.add(value);
    }
    //ищем совпадения и добавляем их в хэшсет
    for (int i = 0; i < (values.size() - 1); i++) {
      String s = values.get(i);
      for (int j = i + 1; j < values.size(); j++) {
        if (s.equals(values.get(j))) {
          duplicates.add(s);
        }
      }
    }
    //передаем значения из хэшсета в метод удаления
    Iterator<String> setIterator = duplicates.iterator();
    while (setIterator.hasNext()) {
      String d = setIterator.next();
      removeItemFromMapByValue(map, d);
    }
  }


  public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
    Iterator<HashMap.Entry<String, String>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      HashMap.Entry<String, String> pair = iterator.next();
      String name = pair.getValue();
      if (name.equals(value)) {
        iterator.remove();
      }
    }
  }

  public static void main(String[] args) {
    HashMap<String, String> map = createMap();
    removeTheFirstNameDuplicates(map);
  }
}