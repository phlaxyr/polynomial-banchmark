package benchmark;

import java.util.Random;

public class main {

	public static void main(String[] args) {

		final int trials = 10000000;
		
		Random rand = new Random();

		int[][] array = new int[trials][8];

		for (int i = 0; i < trials; i++) {
			for (int j = 0; j < 8; j++) {
				array[i][j] = rand.nextInt();
			}
		}
		
		
		//warmup
		for (int i = 0; i < trials; i++) {
			double d = getValue(array[i][0], array[i][1], array[i][2], array[i][3], array[i][4], array[i][5],
					array[i][6], array[i][7]);

			if (d == Double.NaN)
				throw new RuntimeException();
		}
		
		//real thing
		for (int k = 0; k < 20; k++) {
			for (int i = 0; i < trials; i++) {
				for (int j = 0; j < 8; j++) {
					array[i][j] = rand.nextInt();
				}
			}

			long start = System.nanoTime();

			for (int i = 0; i < trials; i++) {
				double d = getValue(array[i][0], array[i][1], array[i][2], array[i][3], array[i][4], array[i][5],
						array[i][6], array[i][7]);

				if (d == Double.NaN)
					throw new RuntimeException();
			}

			long elapsed = System.nanoTime() - start;
			System.out.println(((double) elapsed) / trials);
		}

	}

	public static double getValue(int a, int b, int c, int d, int e, int f, int g, int h) {

		double totalsum = 0;
		for (int i = 0; i < 10; i++) {
			double tosum;
			tosum = (1 / pow(10, i)) * (double) (a * i * i + b * i + c)
					/ (double) (d * i * i * i * i + e * i * i * i + f * i * i + g * i + h);
			totalsum += tosum;
			// the indention is beautiful
		}
		return totalsum;

	}

	public static int pow(int base, int exp) {
		// hardcode cases for exp 0 to 10
		if (exp < 0)
			throw new RuntimeException();
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base;
		if (exp == 2)
			return base * base;
		if (exp == 3)
			return base * base * base;
		if (exp == 4) {
			int t = base * base;
			return t * t;
		}
		if(exp == 5) {
			int t = base * base;
			return t * t * base;
		}
		if(exp == 6) {
			int t = base * base;
			return t * t * t;
		}
		if(exp == 7) {
			int t = base * base;
			return t * t * t * base;
		}
		if(exp == 8) {
			int t = base * base;
			int u = t * t;
			return u * u;
		}
		if(exp == 9) {
			int t = base * base;
			int u = t * t;
			return u * u * base;
		}
		if(exp == 10) {
			int t = base * base;
			int u = t * t;
			return u * u * t;
		}
		
		int result = 1;
		while (exp != 0) {
			// lowest order bit
			if ((exp & 1) == 1)
				result *= base;
			exp >>= 1;
			base *= base;
		}

		return result;
	}
}
