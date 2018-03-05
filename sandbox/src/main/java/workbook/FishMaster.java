package workbook;

/**
 * Created by dteterkin on 23.11.2017.
 */
public class FishMaster {
  public static void main (String[] args){
    Fish myLittleFish = new Fish();
    myLittleFish.dive(2);
    myLittleFish.dive(3);
    System.out.println(myLittleFish.say("привет"));
    myLittleFish.sleep();
  }
}
