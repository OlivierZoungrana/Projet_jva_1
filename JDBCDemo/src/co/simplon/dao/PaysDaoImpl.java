package co.simplon.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import co.simplon.model.Pays;

public class PaysDaoImpl implements PaysDAO {
	
	private DAOContext daoContext;
	
	Connection connexion;
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet result;
	
	
	public PaysDaoImpl(DAOContext daoContext) {
		this.daoContext = daoContext;
	}
	
	@Override
	public void ajouter(Pays pays) {
			
		try {
			
			connexion = DAOContext.get_Connection();
			preparedStatement = connexion.prepareStatement("INSERT INTO testjdbc.pays(nom) VALUES (?);");
			preparedStatement.setString(1, pays.getNom());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	public List<Pays> lister() {
		List<Pays> Lpays = new ArrayList<Pays>();
		
		try {
			 
			 connexion= DAOContext.get_Connection();
			 statement = connexion.createStatement();
			 result = statement.executeQuery("select * from pays");
			
			while (result.next()) {
				
				int id = result.getInt("id");
				String nom = result.getString("nom");
				
				Pays pays = new Pays();
				pays.setNom(nom);
				pays.setId(id);
				Lpays.add(pays);
				
				
			}
			
		}catch(SQLException e) {
			
	} finally {
		
		try {
			
			if(result!= null)
				result.close();
			if (statement!=null)
				statement.close();
			if (connexion!= null)
				connexion.close();
		}catch(SQLException ignore) {
			
		}
	}
		
		return Lpays;
	}
	
	public void modifier(Pays pays) {
		
try {
			
			connexion = DAOContext.get_Connection();
			preparedStatement = connexion.prepareStatement("UPDATE testjdbc.pays set nom=(?) WHERE id=(?)");
			preparedStatement.setInt(1, pays.getId());
			preparedStatement.setString(2, pays.getNom());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void supprimer(Pays pays) {
		
try {
			
			connexion = DAOContext.get_Connection();
			preparedStatement = connexion.prepareStatement("DELETE FROM testjdbc.pays where id=(?)");
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
