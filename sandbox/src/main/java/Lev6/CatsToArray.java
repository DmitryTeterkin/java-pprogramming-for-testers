package Lev6;
/*
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.


Требования:
1. Добавь в класс Cat public статическую переменную cats (ArrayList).
2. Переменная cats должна быть проинициализирована.
3. Метод main должен создавать 10 объектов Cat (используй конструктор Cat()).
4. Метод main должен добавить всех созданных котов в переменную cats.
5. Метод printCats должен выводить всех котов из переменной cats на экран. Каждого с новой строки.
*/

import java.util.ArrayList;

public class CatsToArray {
  public static ArrayList<CatsToArray> cats;//напишите тут ваш код
  static {cats = new ArrayList<CatsToArray>();}

  public CatsToArray() {
    }

  public static void main(String[] args) {
    for (int i = 0; i <10; i++){
      CatsToArray cat = new CatsToArray();
      cats.add(cat);
    }
    printCats();
  }

  public static void printCats() {
    for (int i = 0; i < cats.size(); i++) {
      System.out.println(cats.get(i));    //напишите тут ваш код
    }   //напишите тут ваш код
  }
}
