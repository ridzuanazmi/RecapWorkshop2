public class App {
    public static void main(String[] args) throws Exception {
        BankAccount fredBankAccount = new BankAccount("Fred");
        fredBankAccount.withdraw(-100);
        System.out.println(fredBankAccount.toString());
    }
}
