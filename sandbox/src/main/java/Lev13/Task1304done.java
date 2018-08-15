package Lev13;
/*
Selectable и Updatable
Создай класс Screen и реализуй в нем интерфейсы Selectable и Updatable.
Не забудь реализовать методы!


Требования:
1. Класс Screen должен реализовывать(implements) интерфейс Selectable.
2. Класс Screen должен реализовывать(implements) интерфейс Updatable.
3. В классе Screen должен быть реализованы методы интерфейса Selectable.
4. В классе Screen должен быть реализованы методы интерфейса Updatable.
 */
public class Task1304done {
  public static void main(String[] args) throws Exception {
  }

  interface Selectable {
    void onSelect();
  }

  interface Updatable {
    void refresh();
  }

  public static class Screen implements Selectable, Updatable{

    @Override
    public void onSelect() {

    }

    @Override
    public void refresh() {

    }
  }
}
