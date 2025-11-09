public class Account {
    private double balance = 0;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Can't deposit negative amount");
            return;
        }
        this.balance += amount;
        System.out.println("Deposit: " + amount + " in thread " + Thread.currentThread().getId() + " | Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (amount < 0 || amount > this.balance) {
            System.out.println("Can't withdraw this amount");
            return;
        }
        this.balance -= amount;
        System.out.println("Withdraw: " + amount + " in thread " + Thread.currentThread().getId() + " | Balance: " + balance);
    }
}
