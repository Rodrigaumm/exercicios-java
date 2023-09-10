package lista2.ex02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import lista2.Filenames;
import lista2.utils.Utils;

public class FileInsertion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Student userStudent = new Student();
		userStudent.setName(Utils.getStringInput(sc, "Nome do aluno: "));
		userStudent.setCourse(Utils.getStringInput(sc, "Curso: "));
		userStudent.setGroup(Utils.getStringInput(sc, "Turma: "));
		userStudent.setClassTime(Utils.getStringInput(sc, "Horario: "));

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(Filenames.STUDENTS.getFilename(), true))) {
			bw.write(userStudent.toString() + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(userStudent);

		sc.close();
	}
}
