public class AdjacentPairIndex {
	public static void main(String[] args) throws java.lang.Exception {
		int distance = 0;
		int[] A = { 0, 3, 3, 7, 5, 3, 11, 1 };
		distance = solution(A);
		System.out.println("\nDistance = " + distance);
	}

	private static int solution(int[] A) {
		int P = 0;
		int Q = 1;
		int currDistance = 0;
		int maxDistance = 0;

		int[][] arr = new int[A.length][2];
		for (int i = 1; i < A.length; i++) {
			arr[i][0] = i;
			arr[i][1] = A[i];
		}

		sort(arr, 0, A.length - 1);

		while (P != arr.length - 1) {
			int U = arr[P][1];
			int V = arr[Q - 1][1];
			int W = arr[Q][1];
			boolean isAdjacent = true;

			if ((P != Q - 1) && ((U < V) && (V < W))) {
				isAdjacent = false;
			} else {
				currDistance = Math.abs(arr[P][0] - arr[Q][0]);
				maxDistance = Math.max(maxDistance, currDistance);
				if (arr[P][0] < arr[Q][0])
					System.out.println("Iteration Count: " + P + "→(" + arr[P][0] + ", " + arr[Q][0] + ")");
				else
					System.out.println("Iteration Count: " + P + "→(" + arr[Q][0] + ", " + arr[P][0] + ")");
			}
			Q++;
			if (!isAdjacent || Q == A.length) {
				P++;
				Q = P + 1;

			}
		}

		return maxDistance;
	}

	private static void sort(int arr[][], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int arr[][], int left, int mid, int right) {
		int arrLeft[][] = new int[mid - left + 1][2];
		int arrRight[][] = new int[right - mid][2];

		for (int i = 0; i < arrLeft.length; ++i) {
			arrLeft[i][1] = arr[left + i][1];
			arrLeft[i][0] = arr[left + i][0];
		}
		for (int i = 0; i < arrRight.length; ++i) {
			arrRight[i][1] = arr[mid + 1 + i][1];
			arrRight[i][0] = arr[mid + 1 + i][0];
		}

		int i = 0, j = 0;

		int k = left;
		while (i < arrLeft.length && j < arrRight.length) {
			if (arrLeft[i][1] <= arrRight[j][1]) {
				arr[k][1] = arrLeft[i][1];
				arr[k][0] = arrLeft[i][0];
				i++;
			} else {
				arr[k][1] = arrRight[j][1];
				arr[k][0] = arrRight[j][0];
				j++;
			}
			k++;
		}

		while (i < arrLeft.length) {
			arr[k][1] = arrLeft[i][1];
			arr[k][0] = arrLeft[i][0];
			i++;
			k++;
		}

		while (j < arrRight.length) {
			arr[k][1] = arrRight[j][1];
			arr[k][0] = arrRight[j][0];
			j++;
			k++;
		}
	}
}
