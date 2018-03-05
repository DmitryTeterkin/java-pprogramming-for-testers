package workbook;

public class Pet {
  int age;
  float weight;
  float height;
  String color;
  public void sleep(){
    System.out.println("good night!");
  }
  public void eat(){
    System.out.println("Я голоден, покорми меня!!!");
  }
  public String say(String aWord){
    String petResponce = "Ну ладно!! " +aWord;
    return petResponce;
  }
}
