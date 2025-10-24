package fjp_pr9_adi;

public class Account {
    private double balance = 0;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        if (amount < 0) {
            System.out.println("can't be deposite");
        }
        this.balance += amount;
        System.out.println("Deposite :" + amount + " in thread " + Thread.currentThread().getId() + " Balance is :" + balance);
    }

    public synchronized void withdraw(double amount) {
        if (amount < 0 || amount > this.balance) {
            System.out.println("can't be withdraw");
        }
        this.balance -= amount;
        System.out.println("Withdraw:" + amount + " in thread " + Thread.currentThread().getId() + " Balance is :" + balance);
    }
}

