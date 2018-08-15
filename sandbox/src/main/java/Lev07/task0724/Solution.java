package Lev07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human Alex0 = new Human("Alex0", true, 21);
        Human Alex1 = new Human("Alex1", true, 22);
        Human Alexa2 = new Human("Alexa2", false, 23);
        Human Alexa3 = new Human("Alexa3", false, 24);

        Human Ira = new Human("Ira", false, 24, Alex0, Alexa2);
        Human Ira1 = new Human("Ira1", false, 22, Alex1, Ira);
        Human Ira2 = new Human("Ira3", false, 21, Alex0, Alexa3);
        Human Dima = new Human("Dima1", true, 20, Alex1, Ira1);
        Human Dima1 = new Human("Dima", true, 13, Alex0, Alexa3);
        System.out.println(Alex0);
        System.out.println(Alex1);
        System.out.println(Alexa2);
        System.out.println(Alexa3);

        System.out.println(Ira);
        System.out.println(Ira1);
        System.out.println(Ira2);
        System.out.println(Dima);
        System.out.println(Dima1);

    }

    public static class Human {
        String name;
        Human father, mother;
        boolean sex;
        int age;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}






















