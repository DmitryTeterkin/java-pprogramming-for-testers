package Lev14.Task1408;

public class RussianHen extends Hen {
  @Override
  int getCountOfEggsPerMonth() {
    return 30;
  }

  @Override
  String getDescription() {
    return "Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
  }
}
