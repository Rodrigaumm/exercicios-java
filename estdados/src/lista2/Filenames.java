package lista2;

public enum Filenames {
	PRODUCTS("products.txt"),
	STUDENTS("students.txt");
	
	private final String filename;
	
	Filenames(String filename) {
		this.filename = filename;
	}
	
	public String getFilename() {
		return this.filename;
	}
}
