package prime_no;

public class primeNumber {
    public static void main(String[] args) {
        int i = 1;
        int count = 1, flag = 1;
        System.out.println("First Prime No :" + i);
        while (count < 50) {
            ++i;
            for (int j = 2; j < i / 2; ++j) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                ++count;
                System.out.println(count + "th Prime No = " + i);
            } else
                flag = 1;
        }
    }
}
