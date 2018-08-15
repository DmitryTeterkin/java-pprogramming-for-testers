package Lev05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
      Cat cat1 = new Cat("name1", 12, 12, 12);
      Cat cat2 = new Cat("name2", 1, 13, 11);
      Cat cat3 = new Cat("name3", 15, 15, 15); //напишите тут ваш код
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}