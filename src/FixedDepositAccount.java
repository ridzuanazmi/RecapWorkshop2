public class FixedDepositAccount extends BankAccount {

  private float interestRate = 3;
  private Integer durationInMonth = 6;

  // Constructors
  public FixedDepositAccount(String name, float accountBalance) {
    super(name, accountBalance);
  }

  public FixedDepositAccount(String name, float accountBalance, float interestRate) {
    super(name, accountBalance);
    this.interestRate = interestRate;
  }

  public FixedDepositAccount(String name, float accountBalance, float interestRate, Integer durationInMonth) {
    super(name, accountBalance);
    this.interestRate = interestRate;
    this.durationInMonth = durationInMonth;
  }
  
  @Override
  public void withdraw(float amount) {
    System.out.println("You cannot withdraw from a fixed deposit account");
  }

  @Override
  public void deposit(float amount) {
    System.out.println("You cannot deposit into a fixed deposit account");
  }

  public float getBalance() {
    double interestRatePerPeriod = this.interestRate / 100.0;
    double durationPeriod = this.durationInMonth / 12.0;
    return (float) ((float) super.getAccountBalance() * Math.pow((1 + interestRatePerPeriod), durationPeriod));
  }

  private boolean termInMonthsChanged = false;
  private boolean interestRateChanged = false;

  public void changeTerm(Integer termInMonths) {
    if (termInMonthsChanged) {
      throw new IllegalArgumentException("Term in months has already been changed once");
    }
    this.durationInMonth = termInMonths;
    termInMonthsChanged = true;
  }

  public void changeInterestRate(float interestRate) {
    if (interestRateChanged) {
      throw new IllegalArgumentException("Interest rate has already been changed once");
    }
    this.interestRate = interestRate;
    interestRateChanged = true;
  }

  @Override
  public String toString() {
    return "FixedDepositAccount [accountBalance=" + super.getAccountBalance() + ", interestRate=" + interestRate + ", termInMonths=" + durationInMonth
        + ", termInMonthsChanged=" + termInMonthsChanged + ", interestRateChanged=" + interestRateChanged + "]";
  }
} 