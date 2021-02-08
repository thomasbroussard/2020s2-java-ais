package fr.epita.viz;

import java.sql.*;

public class TestDatabaseConnection {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
		String schema = connection.getSchema();
		System.out.println(schema);

		PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO TABLE_A (pk,val) values (?, ?)");
		insertStatement.setInt(1, 99);
		insertStatement.setString(2, "ZEBRA");
		insertStatement.execute();

		PreparedStatement selectStatement = connection.prepareStatement("select pk, val from table_a");
		ResultSet resultSet = selectStatement.executeQuery();
		while (resultSet.next()){
			String pk = resultSet.getString("pk");
			String val = resultSet.getString("val");
			System.out.println(pk + " " + val);
		}


	}

}
