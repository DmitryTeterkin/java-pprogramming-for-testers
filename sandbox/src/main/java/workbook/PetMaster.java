package workbook;

public class PetMaster {
  public static void main(String[] args){
    String petReaction;
    Pet myPet = new Pet();
    myPet.eat();
    petReaction = myPet.say("Чик!!! Чирик!!!!");
    System.out.println(petReaction);
    myPet.sleep();
    Fish myFish = new Fish();
    myFish.dive(2);
    myFish.dive(97);
    myFish.dive(3);
    System.out.println(myFish.say("привет!"));
    myFish.sleep();
  }
}
