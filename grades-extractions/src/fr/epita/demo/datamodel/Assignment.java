package fr.epita.demo.datamodel;

public class Assignment {
	private String name;
	private Double maxGrade;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMaxGrade() {
		return maxGrade;
	}

	public void setMaxGrade(Double maxGrade) {
		this.maxGrade = maxGrade;
	}

	@Override
	public String toString() {
		return "Assignment{" +
				"name='" + name + '\'' +
				", maxGrade=" + maxGrade +
				'}';
	}
}
