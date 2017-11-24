package workbook;

/**
 * Created by dteterkin on 23.11.2017.
 */
public class Car {
  public void start(){
    System.out.println("Два счетчика! Поехали начальник!");
  }
  public void stop(){
    System.out.println("Приехали! Кто тут временный, слазь, кончилось ваше время!");
  }
  public int drive(int howlong){
    int distance = howlong*60;
    return distance;
  }
}
