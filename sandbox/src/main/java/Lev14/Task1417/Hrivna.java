package Lev14.Task1417;

public class Hrivna extends Money {
  public Hrivna(double amount) {
    super(amount);
  }

  @Override
  public double getAmount() {
    return 25.9;
  }

  @Override
  public String getCurrencyName() {
    return "UAH";
  }
}
