package fr.epita.demo;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import fr.epita.demo.datamodel.Result;
import fr.epita.demo.services.TeamsCSVExtractor;

public class Main {
	public static final String DELIM = "\",\"";


	public static void main(String[] args) throws IOException {
		System.out.println("hello!");
		List<String> list = new ArrayList<String>();
		String pathname = "S:/downloads/assignment1.csv";
		String secondPathName = "S:/downloads/assignment2.csv";

		TeamsCSVExtractor extractor = new TeamsCSVExtractor(DELIM);
		extractor.read(pathname, DELIM)
				.read(secondPathName, DELIM);

		List<Result> assignment1Result = extractor.getResultsFromAssignmentName("Complete the ddl provided");

		Double average = assignment1Result
				.stream()
				.mapToDouble(Result::getGrade)    //"map"
				.average().getAsDouble();//"reduce"

		System.out.println(average);

		Map<Double, Integer> gradesDistribution = new LinkedHashMap<>();
		for (Result result : assignment1Result){
			Double grade = result.getGrade();
			Integer actualCount = gradesDistribution.get(grade);
			gradesDistribution.put(grade , actualCount == null ? 1 : actualCount + 1);
		}
		System.out.println(gradesDistribution);
		//5.0 : ==
		//4.0 : ====
		//3.0 : ==

		System.out.println(assignment1Result.size());
	}
}
