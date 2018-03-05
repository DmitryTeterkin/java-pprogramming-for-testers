package workbook;

import org.testng.Assert;
import org.testng.annotations.Test;
import workbook.Square;

/**
 * Created by Dmitry on 25.01.2017.
 */
public class SquareTests {
@Test
  public void testArea(){
    Square s = new Square(5);
  Assert.assertEquals(s.area(), 25,0);
  }
}
