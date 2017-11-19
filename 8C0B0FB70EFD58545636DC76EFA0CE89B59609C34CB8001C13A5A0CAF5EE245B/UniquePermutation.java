package test;

import java.util.HashSet;
import java.util.Set;

public class UniquePermutation {
	public static void main(String[] args) {
		int n = 1010;
		System.out.println("\nSize: " + solution(n));
	}

	public static int solution(int N) {
		if (N < 10)
			return 1;

		Set<String> set = permutation("", String.valueOf(N));
		set.forEach(data -> System.out.println(data));
		return set.size();
	}

	private static Set<String> permutation(String prefix, String str) {
		Set<String> set = new HashSet<>();
		int n = str.length();
		if (n == 0 && !prefix.startsWith("0"))
			set.add(prefix);
		else {
			for (int i = 0; i < n; i++)
				set.addAll(permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)));
		}

		return set;
	}
}
