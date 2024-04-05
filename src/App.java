import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {

        // testFredBankAccount();
        testFredFixedDepositAccount();
    }

    private static void testFredBankAccount() {
        BankAccount fredBankAccount = new BankAccount("Fred");
        fredBankAccount.deposit(100);
        fredBankAccount.withdraw(50);
        System.out.println(fredBankAccount.toString());
    }

    private static void testFredFixedDepositAccount() {
        FixedDepositAccount fredFixedDepositAccount = new FixedDepositAccount("Fred", 100);
        System.out.println(fredFixedDepositAccount.toString());
        float fredBalance = fredFixedDepositAccount.getBalance();
        System.out.println(fredBalance);
        // fredFixedDepositAccount.changeInterestRate(4);
        // fredFixedDepositAccount.changeTerm(6);
        // System.out.println(fredFixedDepositAccount.toString());
        // fredFixedDepositAccount.deposit(1000);
        // fredFixedDepositAccount.withdraw(500);
        // fredFixedDepositAccount.getAccountBalance();
        // System.out.println(fredFixedDepositAccount.toString());
    }
}
