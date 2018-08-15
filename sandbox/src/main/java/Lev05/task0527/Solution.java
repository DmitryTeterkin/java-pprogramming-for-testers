package Lev05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Cat tomCat = new Cat("Tom", 50, 50);
        Dog dogSpike = new Dog("Spike", 80,60);
        //напишите тут ваш код
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat {
        String name;
        int height;
        int mind;//напишите тут ваш код

        public Cat(String name, int height, int mind) {
            this.name = name;
            this.height = height;
            this.mind = mind;
        }
    }
    public static class Dog {
        String name;
        int height;
        int tearth;//напишите тут ваш код

        public Dog(String name, int height, int tearth) {
            this.name = name;
            this.height = height;
            this.tearth = tearth;
        }
    }
}