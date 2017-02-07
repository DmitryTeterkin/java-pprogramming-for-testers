package workbook;

// создаем запускаемый класс segmentLength для отображения результатов вычисления расстояния между точками.
public class segmentLength {

  private static Double Lenght;

  public static void main(String[] args) {
    Point p1 = new Point(2.0, 12.0); // создаем точку 1
    Point p2 = new Point(-15.0, -90.0); // создаем точку 2

    // выводим результат расчета длины отрезка с помощью функции
    System.out.println("Расстояние между точками А(" + p1.x + "," + p1.y + ") и B(" + p2.x + "," + p2.y + ") = "+ Point.distanceFuncion(p1, p2));


    p1.x = 10.0; p1.y = 10.0; // создаем точку 1 для вызова функции через метод
    p2.x = 70.0; p2.y = 80.0; // создаем точку 2 для вызова функции через метод
    Lenght = p1.distanceMethod(p1,p2); // вычисляем длину отрезка

//вывод результата вычисления
    System.out.println("Расстояние между точками А("+ p1.x + "," + p1.y + ") и B(" + p2.x + "," + p2.y +") = " + Lenght);
  }
}