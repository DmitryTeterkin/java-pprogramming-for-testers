package Lev8;
/*
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.


Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое
детей и выводить все объекты Human на экран.
 */
public class Task0824 {
 /* public static void main(String[] args) {
    //напишите тут ваш код
  }

  public static class Human {
    //напишите тут ваш код

    public String toString() {
      String text = "";
      text += "Имя: " + this.name;
      text += ", пол: " + (this.sex ? "мужской" : "женский");
      text += ", возраст: " + this.age;

      int childCount = this.children.size();
      if (childCount > 0) {
        text += ", дети: " + this.children.get(0).name;

        for (int i = 1; i < childCount; i++) {
          Human child = this.children.get(i);
          text += ", " + child.name;
        }
      }
      return text;
    }
  }
  */
}
