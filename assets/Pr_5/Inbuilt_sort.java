

import java.util.Arrays;

public class Inbuilt_sort {
    public static void main(String[] args) {
        // storing input in variable
        int n = 4;

        // create string array called names
        String names[] = { "Rahul", "Ajay", "Gourav", "Riya" };

        // inbuilt sort function
        Arrays.sort(names);

        // print output array
        System.out.println("The names in alphabetical order are:");
        for (int i = 0; i < n; i++) {
            System.out.println(names[i]);
        }
    }
}
