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

/**
 * Classe che gestisce la connessione ad un database SQLite3
 * 
 * @author Valerio
 *
 */
public class DBHandler
{
	/**
	 * URL del database
	 */
	private static final String URL = "jdbc:sqlite:metodologie_Pescatori.1807838/fabbricasemantica/fabbricasemantica.db";

	/**
	 * Restituisce un oggetto {@link Connection} dal quale si possono eseguire varie
	 * query e ottenere informazioni sul database. Si raccomanda di deregistrare il
	 * driver al termine delle operazioni tramite l'apposito metodo {@link DriverManager#deregisterDriver(java.sql.Driver)}
	 * 
	 * @return l'oggetto {@link Connection}
	 */
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

	/**
	 * Esegue una query di inserimento
	 * @param table table in cui si vogliono inserire dati 
	 * @param values valori delle varie colonne della tabella
	 */
	public static void insertQuery(String table, Object... values)
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

	/**
	 * metodo che ritorna un {@code Array} di {@code String} contenente tutte le colonne della table selezionata
	 * @param table table della quale si vogliono conoscere le colonne
	 * @return Array con una stringa per ogni colonna
	 */
	public static String[] getTableColumns(String table)
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

	/**
	 * Select query, vengono selezionate tutte le colonne della table specificata
	 * @param table table della quale si vogliono selezionare tutte le colonne
	 * @return mappa che associa ad ogni colonna un array con i valori presenti nelle varie righe della colonna
	 */
	public static Map<String, ArrayList<String>> selectQuery(String table)
	{
		return selectQuery(table, getTableColumns(table));
	}

	/**
	 * Select query, è possibile specificare di quali colonne si vuole eseguire il select
	 * @param table  tabella dalla quale effettuare il select
	 * @param columns colonne da selezionare (vuoto per selezionarle tutti)
	 * @return mappa che associa ad ogni colonna un array con i valori presenti nelle varie righe della colonna
	 */
	public static Map<String, ArrayList<String>> selectQuery(String table, String... columns)
	{
		Map<String, ArrayList<String>> map = new HashMap<>();
		String sql = "";
		if (columns.length == 0)
			sql += "SELECT * FROM " + table;
		else
			sql = Arrays.stream(columns).collect(Collectors.joining(", ", "SELECT ", " FROM " + table));
		try (Connection connection = getConnection())
		{
			Statement statement = connection.createStatement();
			// ottengo i nomi dei campi e do in output una mappa
			for (String s : columns)
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
