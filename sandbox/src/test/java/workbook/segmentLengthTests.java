package workbook;

import org.testng.Assert;
import org.testng.annotations.Test;
import workbook.Point;

/**
 * Created by dteterkin on 25.01.2017.
 */
public class segmentLengthTests {

  @Test

  public void testdistanceMethod() {

    Point p1 = new Point(12, 13);
    Point p2 = new Point(-12, -13);
     // сравнение через метод
    Assert.assertEquals(p1.distanceMethod(p1, p2), 35.38361202590826);

    Point p3 = new Point(-12, 13);
    Point p4 = new Point(-2, -13);
     // сравнение через функцию
    Assert.assertEquals(Point.distanceFuncion(p3, p4), 27.85677655436824);


  }
}
