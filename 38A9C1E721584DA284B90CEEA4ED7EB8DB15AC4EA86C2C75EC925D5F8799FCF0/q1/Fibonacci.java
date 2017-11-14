import java.math.BigInteger;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 8181;
		System.out.println(fibonacci(n));
	}

	private static BigInteger fibonacci(int n) {
		// BigInteger is chosen over long,
		// to support high range of output
		BigInteger f[] = new BigInteger[n + 1];

		// f(n) = 0, n = 0
		f[0] = BigInteger.ZERO;
		// f(n)= 1, n = 1
		f[1] = BigInteger.ONE;

		for (int i = 2; i <= n; i++) {
			// f(n) = f(n-1) + f(n-2), n > 1
			f[i] = f[i - 1].add(f[i - 2]);
		}

		return f[n];
	}
}
