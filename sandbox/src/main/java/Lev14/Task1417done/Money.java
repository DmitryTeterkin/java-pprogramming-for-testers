package Lev14.Task1417done;

public abstract class Money {
  private double amount;

  public Money(double amount) {
    setAmount(amount);
  }
  public void setAmount(double amount) {
    this.amount = amount;
  }
  public double getAmount() {
    return amount;
  }

  public abstract String getCurrencyName();
}