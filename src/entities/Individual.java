package entities;

public class Individual extends TaxPayer {

  private double healthExpenditures;

  public Individual(String name, double anualIncome, double healthExpenditures) {
    super(name, anualIncome);
    this.healthExpenditures = healthExpenditures;
  }

  public double getHealthExpenditures() {
    return healthExpenditures;
  }

  public void setHealthExpenditures(double healthExpenditures) {
    this.healthExpenditures = healthExpenditures;
  }

  @Override
  public double tax() {
    double basicTax = (getAnualIncome() < 20000.0) ? getAnualIncome() * 0.15 : getAnualIncome() * 0.25;

    basicTax -= getHealthExpenditures() * 0.5;

    if (basicTax < 0.0) basicTax = 0.0;

    return basicTax;
  }
  
}