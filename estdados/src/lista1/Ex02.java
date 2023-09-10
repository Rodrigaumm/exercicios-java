package lista1;

import java.util.Arrays;
import java.util.function.BiFunction;

import javax.swing.JOptionPane;

public class Ex02 {

	public static Integer binarySearch(int[] list, int target) {
		int targetIndex = -1;

		int low = 0;
		int high = list.length - 1;
		int middle;

		while (true) {
			middle = ((high - low) / 2) + low;
			

			if (list[middle] > target) {
				high = middle - 1;
			} else if (list[middle] < target) {
				low = middle + 1;
			} else {
				targetIndex = middle;
				break;
			}
			
		}

		return targetIndex;
	}

	public static Integer linearSearch(int[] list, int target) {
		int targetIndex = -1;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == target) {
				targetIndex = i;
				break;
			}
		}

		return targetIndex;
	}

	public static void showInputErrorMessage() {
		JOptionPane.showMessageDialog(null, "Entrada invalida. Tente novamente!");
	}

	public static int[] getNumbersInput() {
		while (true) {
			String commaSeparatedList = JOptionPane.showInputDialog(
					"Entre com uma lista de inteiros separados por virgula" + "\n\n" + "Exemplo: 1,2,3,4,5");

			if (commaSeparatedList != null) {
				boolean validList = true;
				String[] stringNumberArray = commaSeparatedList.strip().split(",");
				int[] toSort = new int[stringNumberArray.length];
				for (int i = 0; i < stringNumberArray.length; i++) {
					try {
						toSort[i] = Integer.parseInt(stringNumberArray[i]);
					} catch (NumberFormatException e) {
						validList = false;
						break;
					}
				}

				if (validList) {
					return toSort;
				}

				showInputErrorMessage();
			} else {
				System.exit(0);
				return null;
			}
		}
	}

	public static Integer getSearchTargetInput() {
		int target = -1337;
		while (true) {
			try {
				String userInput = JOptionPane.showInputDialog("Numero alvo a ser encontrado na lista:");
				if (userInput == null) {
					System.exit(0);
					return null;
				}

				target = Integer.parseInt(userInput);
				return target;
			} catch (NumberFormatException e) {
				showInputErrorMessage();
			}
		}
	}

	public static BiFunction<int[], Integer, Integer> getSearchMethod() {
		while (true) {
			String userInputString = JOptionPane
					.showInputDialog("Escolha uma opcao:" + "\n\n" + "1 - Busca linear\n" + "2 - Busca binaria");
			if (userInputString == null) {
				System.exit(0);
				return null;
			}

			int userInput = -1337;
			try {
				userInput = Integer.parseInt(userInputString);
			} catch (NumberFormatException e) {
				showInputErrorMessage();
				continue;
			}

			switch (userInput) {
			case 1:
				return Ex02::linearSearch;
			case 2:
				return Ex02::binarySearch;
			default:
				showInputErrorMessage();
			}
		}
	}

	public static void main(String[] args) {
		int[] list = getNumbersInput();
		Integer target = getSearchTargetInput();
		BiFunction<int[], Integer, Integer> searchMethod = getSearchMethod();
		Integer targetIndex = searchMethod.apply(list, target);

		StringBuilder msgStringBuilder = new StringBuilder();
		msgStringBuilder.append("O alvo \"" + target + "\" ");
		if (targetIndex == -1) {
			msgStringBuilder.append("nao foi encontrado na seguinte lista:\n\n");
		} else {
			msgStringBuilder.append("foi encontrado no indice " + targetIndex + " da seguinte lista:\n\n");
		}
		msgStringBuilder.append(Arrays.toString(list));

		JOptionPane.showMessageDialog(null, msgStringBuilder);
	}

}