package Lev05.task0510;

/*
7. У класса должен быть метод initialize, принимающий в качестве параметра имя, но инициализирующий все переменные класса, кроме адреса.
8. У класса должен быть метод initialize, принимающий в качестве параметров имя, вес, возраст и инициализирующий все переменные класса, кроме адреса.
9. У класса должен быть метод initialize, принимающий в качестве параметров имя, возраст и инициализирующий все переменные класса, кроме адреса.
10. У класса должен быть метод initialize, принимающий в качестве параметров вес, цвет и инициализирующий все переменные класса, кроме имени и адреса.
11. У класса должен быть метод initialize, принимающий в качестве параметров вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
Кошкоинициация
*/

public class Cat {
   String name = null, address = null, color = null;
   int age, weight;
   public void initialize (String name){
       this.name = name;
       this.age = 10;
       this.color = "red";
       this.weight = 3;
   }
    public void initialize (String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "red";
    }
    public void initialize (String name, int age){
        this.name = name;
        this.weight = 5;
        this.age = age;
        this.color = "red";
    }

    public void initialize (int weight, String color){
        this.weight = weight;
        this.age = 3;
        this.color = color;
    }
    public void initialize (int weight, String color, String address){
        this.weight = weight;
        this.age = 5;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
