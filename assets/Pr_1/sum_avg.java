package fjp_pr1;

import java.util.Scanner;

public class sum_avg {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double no,sum =0, avg;
		int n;
		System.out.print("How many numbers you want to enter: ");
		n = in.nextInt();
		for( int i = 1; i<= n; ++i)
		{
		System.out.print("Enter the No: ");
		no = in.nextDouble();
		sum += no;
		}
		avg = sum/n;
		System.out.println("Avg of " + n + " number is "+ avg);
		
		in.close();
	}

}