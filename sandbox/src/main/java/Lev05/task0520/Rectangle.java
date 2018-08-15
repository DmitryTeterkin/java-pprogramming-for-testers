package Lev05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
Примеры:
- заданы 4 параметра: left, top, width, height
- ширина/высота не задана (оба равны 0)
- высота не задана (равно ширине) создаём квадрат
- создаём копию другого прямоугольника (он и передаётся в параметрах)
*/


public class Rectangle {
    int top, left, width, height;

    public Rectangle(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int top, int left) {
        this.top = top;
        this.left = left;
        this.height = 0;
        this.width = 0;
    }

    public Rectangle(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }
    public Rectangle (Rectangle re){
        this.height = re.height;
        this.width = re.width;
        this.left = re.left;
        this.top = re.top;
    }

    public static void main(String[] args) {

    }
}
