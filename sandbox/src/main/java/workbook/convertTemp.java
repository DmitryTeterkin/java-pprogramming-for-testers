package workbook;

public class convertTemp {

  public convertTemp(int temperature, char convertTo) {

  }

  public double convertTemp(int temperature, char convertTo) {
    double result = 0;
    if (convertTo == 'C') {
      result = (temperature * 9 / 5) + 32;
    } else {
      result = (temperature - 32) * 5 / 9;
    }
    return result;
  }
}
