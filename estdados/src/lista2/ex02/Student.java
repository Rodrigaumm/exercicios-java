package lista2.ex02;

public class Student {
	private String name, course, group, classTime;

	public Student() {
	}
	
	public Student(String name, String course, String group, String classTime) {
		this.name = name;
		this.course = course;
		this.group = group;
		this.classTime = classTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(";");
		builder.append(course);
		builder.append(";");
		builder.append(group);
		builder.append(";");
		builder.append(classTime);
		return builder.toString();
	}
}
