package lista2.ex01;

public class Product {

	private String name, measureUnit, brand;
	private Double value, quantity;

	public Product() {
	}

	public Product(String name, String measureUnit, String brand, Double value, Double quantity) {
		this.name = name;
		this.measureUnit = measureUnit;
		this.brand = brand;
		this.value = value;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(";");
		builder.append(measureUnit);
		builder.append(";");
		builder.append(brand);
		builder.append(";");
		builder.append(value);
		builder.append(";");
		builder.append(quantity);
		return builder.toString();
	}
}
