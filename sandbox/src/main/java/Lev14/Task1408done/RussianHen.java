package Lev14.Task1408done;

public class RussianHen extends Hen {
  @Override
  int getCountOfEggsPerMonth() {
    return 30;
  }

  @Override
  String getDescription() {
    return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
  }
}
