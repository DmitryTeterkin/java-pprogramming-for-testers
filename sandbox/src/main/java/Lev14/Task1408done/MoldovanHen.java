package Lev14.Task1408done;

public class MoldovanHen extends Hen {
  @Override
  int getCountOfEggsPerMonth() {
    return 25;
  }

  @Override
  String getDescription() {
    return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
  }
}
