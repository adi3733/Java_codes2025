package fjp_pr9_adi;

public class WithdrawThread implements Runnable {
    private Account account;
    private double amount;

    public WithdrawThread(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.withdraw(amount);
    }
}

