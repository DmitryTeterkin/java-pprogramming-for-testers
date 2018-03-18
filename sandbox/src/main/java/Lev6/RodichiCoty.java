package Lev6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RodichiCoty {
  /*
Родственные связи кошек
Задача: У каждой кошки есть имя и кошка-мама.
Создать класс, который бы описывал данную ситуацию.
Создать два объекта: кошку-дочь и кошку-маму.
Вывести их на экран.

Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама.
Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку (папин папа), бабушку (мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей

*/


    public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      Cat grandFather = new Cat(reader.readLine(), null, null);
      Cat grandMother = new Cat(reader.readLine(), null, null);

      Cat father = new Cat(reader.readLine(), null, grandFather);
      Cat mother = new Cat(reader.readLine(), grandMother, null);

      Cat son = new Cat(reader.readLine(), mother, father);
      Cat daughter = new Cat(reader.readLine(), mother, father);

      System.out.println(grandFather);
      System.out.println(grandMother);

      System.out.println(father);
      System.out.println(mother);

      System.out.println(son);
      System.out.println(daughter);
    }

    public static class Cat {
      private String name;
      private Cat mother;
      private Cat father;

      Cat(String name, Cat mother, Cat father) {
        this.name = name;
        this.mother = mother;
        this.father = father;
      }

      @Override
      public String toString() {

        if (father == null && mother == null) {
          return "Cat name is " + name + ", no mother, no father";
        } else if (father == null) {
          return "Cat name is " + name + ", mother is " + mother.name + ", no father";
        } else if (mother == null) {
          return "Cat name is " + name + ", no mother, father is " + father.name;
        } else {
          return "Cat name is " + name + ", mother is " + mother.name + " father is " + father.name;
        }
      }
    }
  }
