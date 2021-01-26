package fr.epita.demo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import fr.epita.demo.datamodel.Assignment;
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
		extractor.readFromFile(pathname, DELIM);
		extractor.getResultsFromAssignmentName("Complete the ddl provided");

		System.out.println(extractor.getResults());
	}
}
