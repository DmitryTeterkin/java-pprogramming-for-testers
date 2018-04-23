package Lev8;

import java.util.HashSet;
import java.util.Set;

/*
Создать множество строк (Set<String>), занести в него 20 слов на букву "Л".


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Task0925done должен содержать только два метода.
4. Метод createSet() должен создавать и возвращать множество (реализация HashSet).
5. Множество из метода createSet() должно содержать 20 слов на букву «Л».

 сделано!!!
 */
public class Task0813done {
  public static Set<String> createSet() {
   HashSet<String> set = new HashSet<>();
    set.add("л1");
    set.add("л2");
    set.add("л3");
    set.add("л4");
    set.add("л5");
    set.add("л6");
    set.add("л7");
    set.add("л8");
    set.add("л9");
    set.add("л10");
    set.add("л11");
    set.add("л12");
    set.add("л13");
    set.add("л14");
    set.add("л15");
    set.add("л16");
    set.add("л17");
    set.add("л18");
    set.add("л19");
    set.add("л20");
   return set;
  }

  public static void main(String[] args) {
   Set<String> set = createSet();
   // System.out.println(set);
  }
}
