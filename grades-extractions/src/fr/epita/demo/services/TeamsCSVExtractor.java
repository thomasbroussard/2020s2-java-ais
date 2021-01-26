package fr.epita.demo.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.epita.demo.datamodel.Assignment;
import fr.epita.demo.datamodel.Result;
import fr.epita.demo.datamodel.Student;

public class TeamsCSVExtractor {

	private final String delim;
	private List<Result> results;

	public TeamsCSVExtractor(String delim) {
		this.delim = delim;
	}

	public List<Student> extractStudents(List<String> lines) {
		List<Student> students = new ArrayList<>();
		for (String line : lines) {

			String[] parts = line.split(delim);
			line = line.replaceAll("\"", "");
			System.out.println(parts[0]);
			students.add(new Student(parts[0], parts[1], parts[2]));
		}
		return students;
	}

	public List<Result> extractResults(List<String> lines, Assignment assignment) {
		List<Result> results = new ArrayList<Result>();
		for (String line : lines) {

			String[] parts = line.split(delim);
			line = line.replaceAll("\"", "");
			System.out.println(parts[0]);
			if (assignment.getMaxGrade() == null) {
				assignment.setMaxGrade(Double.parseDouble(parts[4]));
			}
			Student student = new Student(parts[0], parts[1], parts[2]);
			String gradeAsString = parts[3];
			Double actualGrade = 0.0;
			if (!gradeAsString.isEmpty()){
				try {
					actualGrade = Double.parseDouble(gradeAsString);
				}catch(Exception e){
					//TODO handle error
					e.printStackTrace();
				}
			}
			results.add(new Result(actualGrade, parts[5], assignment, student));
		}
		return results;
	}

	public void readFromFile(String pathname, String delim) throws IOException {

		List<String> lines = Files.readAllLines(new File(pathname).toPath(), StandardCharsets.ISO_8859_1);
		System.out.println(lines.size());

		String header = lines.remove(0);
		String[] split = header.split(delim);
		Assignment assignment = new Assignment();
		if (split.length > 4) {
			assignment.setName(split[3]);
		} else {
			//we have a structure problem
			return;
		}

		this.results = this.extractResults(lines, assignment);


	}

	public List<Result> getResults() {
		return this.results;
	}

	public List<Result> getResultsFromAssignmentName(String assignmentName) {
		return this.results.stream()
				.filter(r -> r.getAssignment().getName().equals(assignmentName))
				.collect(Collectors.toList());
	}
}
