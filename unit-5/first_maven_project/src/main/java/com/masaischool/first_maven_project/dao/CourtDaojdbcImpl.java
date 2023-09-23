package com.masaischool.first_maven_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masaischool.first_maven_project.dto.Lawyer;
import com.masaischool.first_maven_project.excep.NoRecordFoundExcepion;
import com.masaischool.first_maven_project.excep.SomethingWentWrongException;

public class CourtDaojdbcImpl implements CourtDao{

	
	static boolean isResultEmpty(ResultSet rs) throws SQLException {
		
		return (!rs.isBeforeFirst() && rs.getRow()==0);
	}
	@Override
	public Lawyer findLawyerById(int id) throws NoRecordFoundExcepion,SomethingWentWrongException {


	    Connection conn = null;
	    Lawyer lawyer = null;
		
		try {
			conn = DBUtils.makeConnection();
			
			String searchQuery = "SELECT id,name,email,address,experience FROM lawyer WHERE id = ?";
			
			PreparedStatement ps = conn.prepareStatement(searchQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(isResultEmpty(rs)) {
				throw new NoRecordFoundExcepion("No lawyer is availble with this id");
			}else {
				lawyer = new Lawyer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Unable t osearch Lawyer");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lawyer;
	}

	@Override
	public String saveLawyer(Lawyer lawyer) throws SomethingWentWrongException {
		
		Connection con = null;
		try {
			con = DBUtils.makeConnection();
			
			String addQuery = "INSERT INTO lawyer (id,name,email,address,experience) VALUES(?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(addQuery);
			
			ps.setInt(1, lawyer.getId());
			ps.setString(2, lawyer.getName());
			ps.setString(3, lawyer.getEmail());
			ps.setString(4, lawyer.getAddress());
			ps.setInt(5, lawyer.getExperience());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Unalbe to save lawyer");
		}finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Saved Successfully";
	}

	@Override
	public String deleteLawyerById(int id) throws SomethingWentWrongException, NoRecordFoundExcepion {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DBUtils.makeConnection();
			
			String deleteQuery = "DELETE lawyer WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			
			ps.setInt(1, id);
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Unalbe to delete lawyer");
		}finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Deleted Successfully";
	}

	@Override
	public String updateLawyerExperience(int id, int experience)
			throws SomethingWentWrongException, NoRecordFoundExcepion {
		Connection con = null;
		try {
			con = DBUtils.makeConnection();
			
			String deleteQuery = "UPDATE lawyer SET experience = ? WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			
			ps.setInt(1, id);
			ps.setInt(5, experience);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Unalbe to Update lawyer");
		}finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Updated Successfully";
	}

	

	
}
