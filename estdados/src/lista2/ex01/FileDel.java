package lista2.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import lista2.Filenames;
import lista2.utils.Utils;

public class FileDel {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String searchParameter = Utils.getStringInput(sc, "Nome do produto para pesquisa: ");
		
		StringBuffer stringBuffer = new StringBuffer();
		boolean foundSearch = false;
		try (BufferedReader br = new BufferedReader(new FileReader(Filenames.PRODUCTS.getFilename()))) {
			while (true) {
				boolean shouldDelete = false;
				String line = br.readLine();

				if (line == null)
					break;

				String[] data = line.split(";");
				Product product = new Product(
						data[0], 
						data[1], 
						data[2], 
						Double.parseDouble(data[3]),
						Double.parseDouble(data[4])
				);
				if (data[0].equalsIgnoreCase(searchParameter)) {
					System.out.print("Produto encontrado. Tem certeza que deseja excluir (y/N)? ");
					if (sc.nextLine().equalsIgnoreCase("y")) shouldDelete = true;
					
					foundSearch = true;
				}
				
				if (!shouldDelete)
					stringBuffer.append(product.toString() + "\n");
			}
			
			if (!foundSearch)
				System.out.println("Produto nao encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (!foundSearch) return;
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(Filenames.PRODUCTS.getFilename()))) {
			bw.write(stringBuffer.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
