package Lev05.task0511;

/* 
5. У класса должен быть метод initialize, принимающий в качестве параметра имя и инициализирующий соответствующую переменную класса.
6. У класса должен быть метод initialize, принимающий в качестве параметров имя, рост и инициализирующий соответствующие переменные класса.
7. У класса должен быть метод initialize, принимающий в качестве параметров имя, рост, цвет и инициализирующий соответствующие переменные класса.Создать класс Dog
*/

public class Dog {
    String name;
    int height;
    String color;
    public void initialize (String name){
        this.name = name;
    }
    public void initialize (String name, int height){
        this.name = name;
        this.height = height;
    }
    public void initialize (String name, int height, String color){
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
