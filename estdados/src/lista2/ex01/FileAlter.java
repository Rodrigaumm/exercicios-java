package lista2.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import lista2.Filenames;
import lista2.utils.Utils;

public class FileAlter {

	public static Product alterProduct(Scanner sc, Product product) {
		System.out.println("Para manter um dado, entre com Enter\n");
		
		String newName = Utils.getStringInput(sc, "Nome atual: "+product.getName()+"\nNovo nome: ");
		if (!newName.equals("")) product.setName(newName);
		System.out.println();
		
		String newMeasureUnit = Utils.getStringInput(sc, "Unidade de medida atual:"+product.getMeasureUnit()+"\nNova unidade de medida: ");
		if (!newMeasureUnit.equals("")) product.setMeasureUnit(newMeasureUnit);
		System.out.println();
		
		String newBrand = Utils.getStringInput(sc, "Marca atual:"+product.getBrand()+"\nNova marca: ");
		if (!newBrand.equals("")) product.setBrand(newBrand);
		System.out.println();
		
		String newValue = Utils.getStringInput(sc, "Valor atual:"+product.getValue()+"\nNovo valor: ");
		if (!newValue.equals("")) product.setValue(Double.parseDouble(newValue));
		System.out.println();
		
		String newQuantity = Utils.getStringInput(sc, "Quantidade atual:"+product.getQuantity()+"\nNova quantidade: ");
		if (!newQuantity.equals("")) product.setQuantity(Double.parseDouble(newQuantity));
		System.out.println();
		
		System.out.println("\nProduto atualizado:\n" + product);
		
		return product;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String searchParameter = Utils.getStringInput(sc, "Nome do produto para pesquisa: ");

		StringBuffer stringBuffer = new StringBuffer();
		boolean foundSearch = false;
		try (BufferedReader br = new BufferedReader(new FileReader(Filenames.PRODUCTS.getFilename()))) {
			while (true) {
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
					product = alterProduct(sc, product);
					foundSearch = true;
				}
				
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
