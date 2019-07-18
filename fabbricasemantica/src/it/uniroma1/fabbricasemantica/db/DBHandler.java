package it.uniroma1.fabbricasemantica.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.sqlite.JDBC;

public class DBHandler
{
	private static final String URL = "jdbc:sqlite:../eclipse-workspace/fabbricasemantica/fabbricasemantica.db";

	public static Connection getConnection()
	{
		Connection connection = null;
		try
		{
			DriverManager.registerDriver(new JDBC());
			connection = DriverManager.getConnection(URL);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}

	// insert into x values (a,b,c)
	public static void insertQuery(String table, String fields, Object... values)
	{
		try (Connection connection = getConnection())
		{
			String dynValues = "(";
			for (int c = 0; c < values.length - 1; c++)
				dynValues += "?,";
			dynValues += "?)";
			PreparedStatement ps = connection.prepareStatement("insert into " + table + " values" + dynValues);
			int c = 1;
			for (Object s : values)
			{
				ps.setObject(c, s);
				c++;
			}
			ps.executeUpdate();
			ps.close();
			DriverManager.deregisterDriver(new JDBC());
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String[] getTableFields(String table)
	{
		String[] fields = new String[] {};
		try (Connection connection = getConnection())
		{
			Statement statement = connection.createStatement();
			ResultSet fieldsRs = statement.executeQuery("PRAGMA table_info(" + table + ")");
			int c = 0;
			while (fieldsRs.next())
			{
				fields[c] = fieldsRs.getString("name");
				c++;
			}
			fieldsRs.close();
			statement.close();
			DriverManager.deregisterDriver(new JDBC());
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fields;
	}

	public static Map<String, ArrayList<String>> selectQuery(String table)
	{
		return selectQuery(table, getTableFields(table));
	}

	/**
	 * 
	 * @param table  tabella dalla quale effettuare il select
	 * @param fields campi da selezionare (vuoto per *)
	 * @return
	 */
	public static Map<String, ArrayList<String>> selectQuery(String table, String... fields)
	{
		Map<String, ArrayList<String>> map = new HashMap<>();
		String sql = "";
		if (fields.length == 0)
			sql += "SELECT * FROM " + table;
		else
			sql = Arrays.stream(fields).collect(Collectors.joining(", ", "SELECT ", " FROM " + table));
		try (Connection connection = getConnection())
		{
			Statement statement = connection.createStatement();
			// ottengo i nomi dei campi e do in output una mappa
			for (String s : fields)
				map.put(s, new ArrayList<>());
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next())
				for (String field : map.keySet())
					map.compute(field, (x, y) ->
					{
						try
						{
							y.add(rs.getString(field));
						} catch (SQLException e)
						{
							e.printStackTrace();
						}
						return y;
					});
			rs.close();
			statement.close();
			DriverManager.deregisterDriver(new JDBC());
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return map;
	}

}
