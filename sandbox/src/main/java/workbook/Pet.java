package workbook;

/**
 * Created by dteterkin on 23.11.2017.
 */
public class Pet {
  int Age;
  float weight;
  float height;
  String color;

  public void sleep(){
    System.out.println("good night!");
  }

  public void eat(){
    System.out.println("I'm hungry!");
  }

  public String say(String aWord){
    String petResponce = "Ok!! " +aWord;
    return petResponce;
  }
}
