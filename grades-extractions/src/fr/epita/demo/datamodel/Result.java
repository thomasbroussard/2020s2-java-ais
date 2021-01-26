package fr.epita.demo.datamodel;

public class Result {
	private Double grade;
	private String comment;
	private Assignment assignment;
	private Student student;

	public Result(Double grade, String comment, Assignment assignment, Student student) {
		this.grade = grade;
		this.comment = comment;
		this.assignment = assignment;
		this.student = student;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Result{" +
				"grade=" + grade +
				", comment='" + comment + '\'' +
				", assignment=" + assignment +
				", student=" + student +
				'}';
	}
}
