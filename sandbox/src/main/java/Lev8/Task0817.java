package Lev8;

import java.util.HashMap;
import java.util.Iterator;

/*
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только четыре метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, String состоящих из 10 записей.
5. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
6. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().

 надо переделать, имена должны быть одинаковые а не заданы!

  все имена, которые есть в списке проверяем на совпадение. если смя совпадает с другим - добавляем его в новый список.
  после этого запускаем еще одну проверку - если имя совпадает с новым списком - удаляем запись.
 */
public class Task0817 {
  public static HashMap<String, String> createMap() {
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("иванов","иван");
    map.put("петров","петр");
    map.put("степанов","ивар");
    map.put("новиков","ивас");
    map.put("сидоров","иран");
    map.put("кузькин","ичан");
    map.put("васнецов","иван");
    map.put("петрович","изан");
    map.put("иванович","ищан");
    map.put("ивановский","иван");
   // System.out.println(map);
    return map;
  }

  public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
    HashMap<String, String> copy = map;

    Iterator<HashMap.Entry<String, String>> iterator = copy.entrySet().iterator();

    while (iterator.hasNext())
    {
      //получение «пары» элементов
      HashMap.Entry<String, String> pair = iterator.next();
      String value = pair.getValue();        //значение
      iterator.remove();
      if (copy.containsValue(value)) removeItemFromMapByValue(map, value);
    }
  }

  public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {

  }

  public static void main(String[] args) {
    HashMap<String, String> map = createMap();
    removeTheFirstNameDuplicates(map);
  System.out.println(map);
  }

}
