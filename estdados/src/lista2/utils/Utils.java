package lista2.utils;

import java.util.Scanner;

public class Utils {
	public static Double getDoubleInput(Scanner sc, String inputRequestMessage) {
		if (sc == null)
			return null;

		while (true) {
			System.out.print(inputRequestMessage);

			Double numberInput;
			try {
				numberInput = Double.parseDouble(sc.nextLine());
				return numberInput;
			} catch (NumberFormatException e) {
				System.out.println("Entrada invalida. Tente novamente\n");
			}
		}
	}
	
	public static String getStringInput(Scanner sc, String inputRequestMessage) {
		System.out.print(inputRequestMessage);
		return sc.nextLine();
	}
}
