package Lev05.task0523;

/* 
Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод main изменять нельзя.
3. Метод setDescription класса Color должен устанавливать значение переменной description.
4. Метод getDescription класса Color должен возвращать значение переменной description.
5. Программа должна вывести слово "Red" на экран.
Конструктор
*/

public class Circle {
    public Color color;

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.color.setDescription("Red");
        System.out.println(circle.color.getDescription());
    }

    public Circle() {
        color = new Color();
    }

    public class Color {
        String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
