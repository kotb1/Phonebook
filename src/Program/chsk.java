package Program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class chsk {

	public static void main(String[] args) 
	{
		r(1);
	}
	public static void r(int n) 
	{
		int sum=0;
		if(n==0) 
		{
			System.out.println(sum);
		}
		else 
		{
			sum+=n;
			r(n-1);
		}
	}
}
