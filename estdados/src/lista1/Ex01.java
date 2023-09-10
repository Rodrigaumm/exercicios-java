package lista1;

public class Ex01 {

	public static void sort(int[] toSort) {
		for (int i = 1; i < toSort.length; i++) {
			int currentValue = toSort[i];
			int j = i;

			for (; j > 0 && toSort[j - 1] > currentValue; j--) {
				toSort[j] = toSort[j - 1];
			}
			toSort[j] = currentValue;
		}
	}

	public static void main(String[] args) {
		int[] toSort = { 5, 4, 2, 1, 8, 2, 4, 5, 9, 7 };

		sort(toSort);

		for (int x : toSort) {
			System.out.println(x);
		}
	}

}
