package workbook;

/**
 * Created by dteterkin on 23.11.2017.
 */
public class Fish extends Pet {
  int currentDepth = 0;

  public int dive(int howDeep) {
    currentDepth = currentDepth + howDeep;
    System.out.println("ныряю на глубину " + howDeep + " футов");
    System.out.println("Я на глубине " + currentDepth + " футов ниже уровня моря");
    return currentDepth;
  }
  public String say(String something){
    return "рыбы не разговаривают!";
  }

}
