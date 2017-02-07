package workbook;

/**
 * Created by Dmitry on 25.01.2017.
 */
public class Rectangle {
  public double a;
  public double b;

  public Rectangle (double a, double b) {
    this.a = a;
    this.b = b;
  }
  // функция вычисления площади прямоугольника
  public double area () {
    return this.a * this.b;
  }

}
