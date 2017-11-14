public class DiceProblem {

	public static void main(String[] args) {
		int n = 10000000;
		System.out.println(partition(n));
	}

	private static long partition(int targetSum) {
		final int diceFaces = 6;
		// Holds the result of each phases. Each position table[i][j]
		// will be equal to the sum of table[i][j-1]
		long[][] table = new long[targetSum + 1][diceFaces + 1];

		// Initialize first row with 1 from table[1][0]~
		// to represent the sum being equal to 0
		for (int i = 1; i <= diceFaces; i++)
			table[0][i] = 1;

		for (int i = 1; i <= targetSum; i++) {
			for (int j = 1; j <= diceFaces; j++) {
				// When reaches negative value,
				// fill rest of the column with table[i][j-1]
				// of the same row
				if (i - j < 0) {
					table[i][j] = table[i][j - 1];
					continue;
				}
				table[i][j] = table[i][j - 1] + table[i - j][j];
			}
		}

		return table[targetSum][diceFaces];
	}
}
