package Lev8;

import java.util.HashSet;
import java.util.Iterator;

/*
HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, женьшень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.


Требования:
1. Объяви переменную коллекции HashSet с типом элементов String и сразу проинициализируй ee.
2. Программа не должна считывать строки с клавиатуры.
3. Программа должна добавлять в коллекцию 10 строк, согласно условию.
4. Программа должна выводить 10 строк из коллекции на экран, каждую с новой строки.
 */
public class Task0801done {
  public static void main(String[] args) {
    HashSet<String> set = new HashSet<String>();
    set.add("арбуз");
    set.add("банан");
    set.add("вишня");
    set.add("груша");
    set.add("дыня");
    set.add("ежевика");
    set.add("женьшень");
    set.add("земляника");
    set.add("ирис");
    set.add("картофель");
    Iterator<String> iterator = set.iterator();
   while(iterator.hasNext()){
     System.out.println(iterator.next());
   }
  }
}
