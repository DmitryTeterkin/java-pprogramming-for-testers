package Lev14.Task1408done;

public class UkrainianHen extends Hen {
  @Override
  int getCountOfEggsPerMonth() {
    return 15;
  }

  @Override
  String getDescription() {
    return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
  }
}
