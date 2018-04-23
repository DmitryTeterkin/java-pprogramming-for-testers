package Lev8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
1. Внутри класса Task0925done создать public static класс кот - Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве.
Каждый кот с новой строки.


Требования:
1. Программа должна выводить текст на экран.
2. Внутри класса Task0925done должен быть public static класс Cat с конструктором по умолчанию.
3. Метод createCats() класса Task0925done должен возвращать множество (Set) содержащее 3 кота.
4. Метод printCats() класса Task0925done должен вывести на экран всех котов из множества. Каждый кот с новой строки.
5. Метод main() должен один раз вызывать метод createCats().
6. Метод main() должен вызывать метод printCats().
7. Метод main() должен удалять одного кота из множества котов.

 Сделано!!!
 */
public class Task0819done {
 public static void main(String[] args) {
    Set<Cat> cats = createCats();
  // Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
   Iterator<Cat> iterator = cats.iterator();
   Cat s = null;
   if (iterator.hasNext()){
     {s = iterator.next();// break;
     }
   }
   cats.remove(s);

   printCats(cats);
  }

  public static Set<Cat> createCats() {
    Set<Cat> set = new HashSet<Cat>();
    set.add(new Cat());
    set.add(new Cat());
    set.add(new Cat());
    System.out.println(set);
    return set;

  }

  public static void printCats(Set<Cat> cats) {
    Iterator<Cat> iterator = cats.iterator();
     while (iterator.hasNext()){
      {Cat t = iterator.next();// break;
        System.out.println(t);
      }
    }
  }

  public static class Cat{
    public Cat() {

    }
  }

}
