package Lev8;

import java.util.ArrayList;

/*
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.


Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Task0925done должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое
детей и выводить все объекты Human на экран.

Сделано!!!!

 */
public class Task0824done {
 public static void main(String[] args) {
   ArrayList<Human> child = new ArrayList<>();
   Human Son1 = new Human("Son1", true, 5, child);
   Human Son2 = new Human("Son2", true, 7, child);
   Human Douter1 = new Human("Douter1", false, 8, child);
   ArrayList<Human> childrens = new ArrayList<>();
   childrens.add(Son1);childrens.add(Son2);childrens.add(Douter1);
   Human Father = new Human("Father", true, 38, childrens);
   Human Mather = new Human("Mather", false, 35, childrens);
   ArrayList<Human> mother = new ArrayList<>(); mother.add(Mather);
   ArrayList<Human> father = new ArrayList<>(); father.add(Father);
   Human grDad1 = new Human("GrandDad1", true, 80, mother);
   Human grDad2 = new Human("GrandDad2", true, 85, father);
   Human grMam1 = new Human("GrandMam1", false, 79, mother);
   Human grMam2 = new Human("GrandMam2", false, 75, father);
   System.out.println(grDad1);
   System.out.println(grDad2);
   System.out.println(grMam1);
   System.out.println(grMam2);
   System.out.println(Father);
   System.out.println(Mather);
   System.out.println(Son1);
   System.out.println(Son2);
   System.out.println(Douter1);
 }

  public static class Human {
    public Human(String name, boolean sex, int age, ArrayList<Human> children) {
      this.name = name;
      this.sex = sex;
      this.age = age;
      this.children = children;
    }

    public String name;
    public boolean sex;
    public int age;
    public ArrayList<Human> children;


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

}
