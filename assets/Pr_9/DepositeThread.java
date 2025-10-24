package fjp_pr9_adi;

public class DepositeThread extends Thread {
    private Account account;
    private double amount;

    public DepositeThread(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.deposit(amount);
    }
}

