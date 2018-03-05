package workbook;

public class CarOwner {
  public static void main(String[] args){

    JamesBondCar myCar = new JamesBondCar();
    myCar.start();
    int howlong = 4;
    System.out.println("мы проехали на машине Бонда "+ myCar.drive(howlong) +" километров!");
    myCar.stop();
  }
}
