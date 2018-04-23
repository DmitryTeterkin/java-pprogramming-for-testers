package Lev8;

import java.util.HashSet;
import java.util.Iterator;

/*
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Task0925done должен содержать только три метода.
4. Метод createSet() должен создавать и возвращать множество HashSet состоящих из 20 различных чисел.
5. Метод removeAllNumbersMoreThan10() должен удалять из множества все числа больше 10.

 сделано!!!

 */
public class Task0814done {
 public static HashSet<Integer> createSet() { // наполняем сет элементами
    HashSet<Integer> setInt = new HashSet<>();
   for (int i = 0; i < 20; i++) {
     setInt.add(i);
   }

   return setInt;
  }

  public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {// удаляем из сет числа больше 10
    HashSet<Integer> newSet = new HashSet<>(); // для этого нужен второй список
   Iterator<Integer> iterator = set.iterator(); // и используем итератор для выбора значений > 10
    while (iterator.hasNext()){ // выбираем все значения больше 10 и добавляем их в новый список
      int i = iterator.next();
      if (i > 10){
        newSet.add(i);

      }
    }
    set.removeAll(newSet);// удаляем множество newSet из множества set

    return set;

  }

  public static void main(String[] args) {
   HashSet<Integer> set = createSet();
   removeAllNumbersMoreThan10(set);
 }

}
