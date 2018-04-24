package Lev9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Есть класс кот - Cat, с полем "имя" (String).
Создать словарь Map<String, Cat> и добавить туда 10 котов в виде "Имя"-"Кот".
Получить из Map множество(Set) всех котов и вывести его на экран.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод createMap должен создавать новый объект HashMap.
3. Метод createMap должен добавлять в словарь 10 котов в виде «Имя»-«Кот».
4. Метод createMap должен возвращать созданный словарь.
5. Метод convertMapToSet должен создать и вернуть множество котов, полученных из переданного словаря.
6. Программа должна вывести всех котов из множества на экран.
 */
public class Task0927done {
 public static void main(String[] args) {
    Map<String, Cat> map = createMap();
    Set<Cat> set = convertMapToSet(map);
    printCatSet(set);
  }

  public static Map<String, Cat> createMap() {
    HashMap<String, Cat> cats = new HashMap<String, Cat>();
   //HashMap cats = new HashMap(); //вот здесь именно так, иначе не пройдет
    cats.put("Tima", new Cat("Tima"));
    cats.put("Anti", new Cat("Anti"));
    cats.put("Dimi", new Cat("Dimi"));
    cats.put("Timie", new Cat("Timie"));
    cats.put("Lo", new Cat("Lo"));
    cats.put("Andi", new Cat("Andi"));
    cats.put("Lahi", new Cat("Lahi"));
    cats.put("Domh", new Cat("Domh"));
    cats.put("More", new Cat("More"));
    cats.put("Alea", new Cat("Alea"));
    return cats;
  }



  public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
   return new HashSet(map.values()); //напишите тут ваш код
  }

  public static void printCatSet(Set<Cat> set) {
    for (Cat cat : set) {
      System.out.println(cat);
    }
  }

  public static class Cat {
    private String name;

    public Cat(String name) {
      this.name = name;
    }

    public String toString() {
      return "Cat " + this.name;
    }
  }


}
