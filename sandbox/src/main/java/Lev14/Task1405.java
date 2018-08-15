package Lev14;
/*
Food
1. Реализовать интерфейс Selectable в классе Food.
2. Метод onSelect() должен выводить на экран фразу "food was selected".
3. Подумай, какие методы можно вызвать для переменной food и какие для selectable.
4. В методе foodMethods вызови методы onSelect, eat, если это возможно.
5. В методе selectableMethods вызови методы onSelect, eat, если это возможно.
6. Явное приведение типов не использовать.


Требования:
1. Интерфейс Selectable должен быть реализован в классе Food.
2. Метод onSelect() в классе Food должен выводить на экран фразу "food was selected".
3. В методе foodMethods должны вызываться методы объекта типа Food.
4. В методе selectableMethods должны вызываться методы доступные у любого объекта реализующего интерфейс Selectable.
 */
public class Task1405 {
  public static void main(String[] args) {
    Food food = new Food();
    Selectable selectable = new Food();
    Food newFood = (Food) selectable;

    foodMethods(food);
    selectableMethods(selectable);
  }

  public static void foodMethods(Food food) {
    //тут добавьте вызов методов для переменной food
  }

  public static void selectableMethods(Selectable selectable) {
    //тут добавьте вызов методов для переменной selectable
  }

  interface Selectable {
    void onSelect();
  }

  static class Food {
    public void eat() {
      System.out.println("food was eaten");
    }
  }
}
