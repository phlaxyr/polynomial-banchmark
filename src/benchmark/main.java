package benchmark;

import java.util.Random;

public class main {

	public static void main(String[] args) {
		
		Random rand = new Random();

		
		int[][] array = new int[100][8];
		
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<8;j++) {
				array[i][j] = rand.nextInt();
			}
		}
		
		
		double start = System.nanoTime();		
		
		
		for(int i=0;i<100;i++) {
			double d = getValue(array[i][0],array[i][1],array[i][2],array[i][3],array[i][4],array[i][5],array[i][6],array[i][7]);
			
			if(d==Double.NaN) throw new RuntimeException();
		}
		
		double elapsed = System.nanoTime()-start;
		System.out.print(elapsed);


	}
	public static double getValue(int a, int b, int c, int d, int e, int f, int g, int h) {
		
		double totalsum=0;
		for(int i=0;i<10;i++) {
			double tosum;
			tosum = (1/pow(10,i))*
					(double)
					(a*i*i
					+b*i
					+c)
					/
					(double)
					(d*i*i*i*i
					+e*i*i*i
					+f*i*i
					+g*i
					+h);
			totalsum+= tosum;
			// the indention is beautiful
		}
		return totalsum;
		
	}
	public static int pow(int base, int pow) {
		int retn=1;
		for(int i=0;i<pow;i++) {
			retn *=base;
		}
		return retn;
	}
}