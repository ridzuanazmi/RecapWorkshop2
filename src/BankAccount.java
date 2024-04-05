import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BankAccount {

  private final String name;
  private final String accountNumber;
  private float accountBalance;
  private List<String> transactionHistory = new ArrayList<>();
  private boolean isAccountClosed;
  private String openDate;
  private String closeDate;

  public BankAccount(String name) {
    this.accountNumber = UUID.randomUUID().toString();
    this.accountBalance = 0;
    this.name = name;
    this.openDate = getCurrentDateTime();
    System.out.println("Account created successfully on " + this.openDate + "\n Account Number: " + this.accountNumber + "\n Account Balance: " + this.accountBalance + "\n Account Holder name: " + this.name + "\n");
  }

  public BankAccount(String name, float initialDeposit) {
    this.name = name;
    this.accountNumber = UUID.randomUUID().toString();
    this.accountBalance = initialDeposit;
    this.openDate = getCurrentDateTime();
  }

  public void deposit(float amount) {
    if (amount <= 0 || isAccountClosed) {
      throw new IllegalArgumentException("Deposit amount must be greater than 0");
    }
    this.accountBalance += amount;
    this.transactionHistory.add("Deposit $" + amount + " at date time: " + getCurrentDateTime());
  }

  public void withdraw(float amount) {
    if (amount <= 0 || isAccountClosed) {
      throw new IllegalArgumentException("Withdraw amount must be greater than 0");
    }
    if (amount > this.accountBalance) {
      throw new IllegalArgumentException("Insufficient balance");
    }
    this.accountBalance -= amount;
    this.transactionHistory.add("Withdraw $" + amount + "at date time: " + getCurrentDateTime());
  }

  public void closeAccount() {
    if (isAccountClosed) {
      throw new IllegalArgumentException("Account is already closed");
    }
    this.isAccountClosed = true;
    this.closeDate = getCurrentDateTime();
    System.out.println("Account closed successfully on " + this.closeDate + "\n Account Number: " + this.accountNumber + "\n Account Balance: " + this.accountBalance + "\n Account Holder name: " + this.name + "\n");
  }

  private String getCurrentDateTime() {
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentDateTime = dateFormat.format(currentDate);
    return currentDateTime;
  }

  // Getter and Setter methods
  // accountName and accountNumber are final, so they don't have setter methods
  public String getName() {
    return name;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public float getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(float accountBalance) {
    this.accountBalance = accountBalance;
  }

  public List<String> getTransactionHistory() {
    return transactionHistory;
  }

  public void setTransactionHistory(List<String> transactionHistory) {
    this.transactionHistory = transactionHistory;
  }

  public boolean isAccountClosed() {
    return isAccountClosed;
  }

  public void setAccountClosed(boolean isAccountClosed) {
    this.isAccountClosed = isAccountClosed;
  }

  public String getOpenDate() {
    return openDate;
  }

  public void setOpenDate(String openDate) {
    this.openDate = openDate;
  }

  public String getCloseDate() {
    return closeDate;
  }

  public void setCloseDate(String closeDate) {
    this.closeDate = closeDate;
  }

  @Override
  public String toString() {
    return "BankAccount [name=" + name + ", accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
        + ", transactionHistory=" + transactionHistory + ", isAccountClosed=" + isAccountClosed + ", openDate="
        + openDate + ", closeDate=" + closeDate + "]";
  }

}
