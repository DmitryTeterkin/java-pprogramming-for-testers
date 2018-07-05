package Lev10;

/*
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
 */
public class Task1013done {
  public static void main(String[] args) {
  }

  public static class Human {
    //поля класса Human
    private String name, eyecolor, hearcolor;
    private boolean sex;
    private int age, height;

    //конструкторы класса Human
    // конструктор 1 имя пол возраст
    public Human(String name, boolean sex, int age) {
      this.name = name;
      this.sex = sex;
      this.age = age;
    }

    //конструктор 2 все переменные
    public Human(String name, String eyecolor, String hearcolor, boolean sex, int age, int height) {
      this.age = age;
      this.name = name;
      this.eyecolor = eyecolor;
      this.hearcolor = hearcolor;
      this.sex = sex;
      this.height = height;
    }

    // 3 цвет волос и пол
    public Human(String name, String hearcolor, boolean sex) {
      this.name = name;
      this.hearcolor = hearcolor;
      this.sex = sex;
    }

    // 4 пол и цвет волос
    public Human(boolean sex, String hearcolor) {
      this.sex = sex;
      this.hearcolor = hearcolor;
    }

    // 5 пол и цвет глаз
    public Human(String eyecolor, boolean sex) {
      this.sex = sex;
      this.eyecolor = eyecolor;
    }

    // 6 пол и возраст
    public Human(boolean sex, int age) {
      this.sex = sex;
      this.age = age;
    }

    // 7 пол возраст и рост
    public Human(boolean sex, int age, int height) {
      this.sex = sex;
      this.age = age;
      this.height = height;
    }

    // 8 возраст и рост
    public Human(int age, int height) {
      this.age = age;
      this.height = height;
    }

    // 9 имя пол возраст рост
    public Human(String name, boolean sex, int age, int height) {
      this.name = name;
      this.sex = sex;
      this.age = age;
      this.height = height;
    }

    // 10 имя и пол
    public Human(String name) {
      this.name = name;
    }
    // напишите тут ваши переменные и конструкторы
  }
}
