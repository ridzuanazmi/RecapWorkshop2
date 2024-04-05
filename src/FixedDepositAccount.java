public class FixedDepositAccount extends BankAccount {

  private float interestRate = 3;
  private Integer termInMonths = 6;

  // Constructors
  public FixedDepositAccount(String name, float accountBalance) {
    super(name, accountBalance);
  }

  public FixedDepositAccount(String name, float accountBalance, float interestRate) {
    super(name, accountBalance);
    this.interestRate = interestRate;
  }

  public FixedDepositAccount(String name, float accountBalance, float interestRate, Integer termInMonths) {
    super(name, accountBalance);
    this.interestRate = interestRate;
    this.termInMonths = termInMonths;
  }
  
  @Override
  public void withdraw(float amount) {
    System.out.println("You cannot withdraw from a fixed deposit account");
  }

  @Override
  public void deposit(float amount) {
    System.out.println("You cannot deposit into a fixed deposit account");
  }

  public float getAccountBalance() {
    return super.getAccountBalance() + (super.getAccountBalance() * interestRate * termInMonths / 12);
  }

  private boolean termInMonthsChanged = false;
  private boolean interestRateChanged = false;

  public void changeTerm(Integer termInMonths) {
    if (termInMonthsChanged) {
      throw new IllegalArgumentException("Term in months has already been changed once");
    }
    this.termInMonths = termInMonths;
    termInMonthsChanged = true;
  }

  public void changeInterestRate(float interestRate) {
    if (interestRateChanged) {
      throw new IllegalArgumentException("Interest rate has already been changed once");
    }
    this.interestRate = interestRate;
    interestRateChanged = true;
  }
} 