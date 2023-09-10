package lista2.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import lista2.Filenames;
import lista2.utils.Utils;

public class FileAlter {

	public static Student alterStudent(Scanner sc, Student Student) {
		System.out.println("Para manter um dado, entre com Enter\n");

		String newName = Utils.getStringInput(sc, "Nome atual: " + Student.getName() + "\nNovo nome: ");
		if (!newName.equals(""))
			Student.setName(newName);
		System.out.println();

		String newCourse = Utils.getStringInput(sc, "Curso atual:" + Student.getCourse() + "\nNovo curso: ");
		if (!newCourse.equals(""))
			Student.setCourse(newCourse);
		System.out.println();

		String newGroup = Utils.getStringInput(sc, "Turma atual:" + Student.getGroup() + "\nNova turma: ");
		if (!newGroup.equals(""))
			Student.setGroup(newGroup);
		System.out.println();

		String newClassTime = Utils.getStringInput(sc, "Horario atual:" + Student.getClassTime() + "\nNovo horario: ");
		if (!newClassTime.equals(""))
			Student.setClassTime(newClassTime);
		System.out.println();

		System.out.println("\nAluno atualizado:\n" + Student);

		return Student;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String searchParameter = Utils.getStringInput(sc, "Nome do aluno para pesquisa: ");

		StringBuffer stringBuffer = new StringBuffer();
		boolean foundSearch = false;
		try (BufferedReader br = new BufferedReader(new FileReader(Filenames.STUDENTS.getFilename()))) {
			while (true) {
				String line = br.readLine();

				if (line == null)
					break;

				String[] data = line.split(";");
				Student Student = new Student(data[0], data[1], data[2], data[3]);
				if (data[0].equalsIgnoreCase(searchParameter)) {
					Student = alterStudent(sc, Student);
					foundSearch = true;
				}

				stringBuffer.append(Student.toString() + "\n");
			}

			if (!foundSearch)
				System.out.println("Aluno nao encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!foundSearch)
			return;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(Filenames.STUDENTS.getFilename()))) {
			bw.write(stringBuffer.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
