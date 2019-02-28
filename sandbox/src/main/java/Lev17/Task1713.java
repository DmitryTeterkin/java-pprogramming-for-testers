package Lev17;

import java.util.ArrayList;

/*
Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.


Требования:
1. Класс Solution должен реализовывать интерфейс List<Long>.
2. Класс Solution должен содержать private поле original типа ArrayList<Long>.
3. Все переопределенные методы интерфейса List должны делегировать полномочия методам объекта original.
4. Все методы класса Solution, кроме метода main, должны быть синхронизированы.
 */
public class Task1713 {
  private ArrayList<Long> original = new ArrayList<Long>();

  public static void main(String[] args) {

  }
}
