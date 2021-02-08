package fr.epita.viz;

import java.sql.*;

public class TestDatabaseConnectionH2 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "test", "test");
		String schema = connection.getSchema();
		System.out.println(schema);

		PreparedStatement createTable = connection.prepareStatement("CREATE TABLE TABLE_A( PK INT, VAL VARCHAR(255))");
		createTable.execute();


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
