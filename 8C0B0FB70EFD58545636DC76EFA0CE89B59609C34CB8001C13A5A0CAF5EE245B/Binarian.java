public class Binarian {

	public static void main(String[] args) {
		int[] A = { 264, 256, 302, 476, 318, 684, 59, 98, 796, 753, };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		long sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += Math.pow(2, A[i]);
		}
		System.out.println(sum);
		int binarianCount = 0;
		while (sum > 0) {
			binarianCount++;
			int exp = (int) (Math.log(sum) / Math.log(2));
			System.out.print(exp + " ");
			sum -= Math.pow(2, exp);
		}
		System.out.println();
		return binarianCount;
	}
}
