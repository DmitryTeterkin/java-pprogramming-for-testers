package workbook;

/**
 *
 * Создаем класс Point для задания двух точек и функцию, которая будет его вычислять.
 */
public class Point {

  public double x; // координата точки по оси Х;
  public double y; // координата точки по оси Y;

// функция
  public static double distanceFuncion(Point p1, Point p2) {

    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }

//метод
  public double distanceMethod(Point p1, Point p2) {

    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }


 //  Конструктор
 Point(double x, double y) {
 this.x = x;
 this.y = y;
 }

}
