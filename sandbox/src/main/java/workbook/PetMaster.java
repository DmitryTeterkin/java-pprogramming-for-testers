package workbook;

/**
 * Created by dteterkin on 23.11.2017.
 */
public class PetMaster {
  public static void main(String[] args){
    String petReaction;
    Pet myPet;
    myPet = new Pet();
    myPet.eat();
    petReaction = myPet.say("чик чирик!!!");
    System.out.println(petReaction);
    myPet.sleep();
    Fish myLittleFish = new Fish();
    myLittleFish.dive(2);
    myLittleFish.dive(3);
    myLittleFish.say("привет");
    myLittleFish.sleep();
  }
}
