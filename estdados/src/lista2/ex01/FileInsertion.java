package lista2.ex01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import lista2.Filenames;
import lista2.utils.Utils;

public class FileInsertion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Product userProduct = new Product();
		userProduct.setName(Utils.getStringInput(sc, "Nome do produto: "));
		userProduct.setMeasureUnit(Utils.getStringInput(sc, "Unidade de medida: "));
		userProduct.setBrand(Utils.getStringInput(sc, "Marca do produto: "));
		userProduct.setValue(Utils.getDoubleInput(sc, "Valor do produto: "));
		userProduct.setQuantity(Utils.getDoubleInput(sc, "Quantidade: "));

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(Filenames.PRODUCTS.getFilename(), true))) {
			bw.write(userProduct.toString() + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(userProduct);

		sc.close();
	}
}
