package workbook;

/**
 * Created by dteterkin on 24.11.2017.
 */
public class TemperatureConverter {


  public static void main(String[] args) {
    int temperature = 100;
    char degrees = 'F';
    double result;

    result = convertTemp(temperature, degrees);
    System.out.println(result);

  }

  private static double convertTemp(int temperature, char degrees) {
   double result = 0;
    if (degrees == 'C'){
      result = (temperature + 32) * 9 / 5;
    } else {
      result = (temperature - 32)*5/9;
    }

    return result;
  }

}