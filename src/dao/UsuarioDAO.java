package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataBase.ConexionDB;

public class UsuarioDAO {
	public Boolean validarUsuarioYPass(String usuario, String contrasenia) {
		try {
			ConexionDB conexionDB = new ConexionDB();
			Connection connection = conexionDB.establecerConexion();
			Statement statement = connection.createStatement();
			String sql = new String("SELECT * FROM usuarios WHERE usuario = '" + usuario.trim() + "' AND clave ='"+ contrasenia.trim() +"' ");
			System.out.println(sql);
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				return true;
			}
			
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
