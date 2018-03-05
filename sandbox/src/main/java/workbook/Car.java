package workbook;

public class Car {
  public void start(){
    System.out.println("Поехали!!!");
  }
  public void stop(){
    System.out.println("Тормози!!!!");
  }
  public int drive(int howlong){
    int distance;
    distance = howlong*60;
    return distance;
  }
}
