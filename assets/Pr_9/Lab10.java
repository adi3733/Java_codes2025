package fjp_pr9_adi;

public class Lab10 {
    public static void main(String[] args) {
        Thread obj = Thread.currentThread();
        System.out.println("Current thread is " + obj);
        System.out.println("Name of current thread is " + obj.getName());
        obj.setName("Multi Thread"); // Changing name of main thread
        System.out.println("Name of current thread after changing name is " + obj);

        Account accObj = new Account(100);
        Thread t1 = new Thread(new DepositeThread(accObj, 30));
        t1.setName("Deposite Thread");
        System.out.println("Name of current thread is " + t1.getName());
        t1.start();

        Thread t2 = new Thread(new DepositeThread(accObj, 10));
        t2.start();

        Thread t3 = new Thread(new WithdrawThread(accObj, 150));
        t3.start();

        Thread t4 = new Thread(new DepositeThread(accObj, 20));
        t4.start();

        new Thread(new DepositeThread(accObj, 30)).start();
        new Thread(new WithdrawThread(accObj, 30)).start();
    }
}
