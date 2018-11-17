package com.cg.ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.Query;

import org.apache.log4j.jdbc.JDBCAppender;

import com.cg.ams.bean.AssetAllocationBean;
import com.cg.ams.bean.AssetsBean;
import com.cg.ams.bean.EmployeeBean;
import com.cg.ams.bean.UserMasterBean;
import com.cg.ams.exceptions.AssetException;
import com.cg.ams.utility.JdbcUtility;

public class UserDaoImpl implements IUserDao {

	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement statement = null;

	@Override
	public boolean LoginValidate(UserMasterBean bean) throws AssetException {
		connection = JdbcUtility.getConnection();
		boolean result = false;
		try {

			statement = connection.prepareStatement(QueryConstant.fetchUser);
			statement.setString(1, bean.getUserType());

			resultSet = statement.executeQuery();
			resultSet.next();
			if (resultSet.getString(1).equals(bean.getUserName())
					&& resultSet.getString(2).equals(bean.getUserPassword())) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
int result=0;
	@Override
	public int Allocate(int empId, String assetname) throws AssetException {

		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryConstant.ReqTableUpdate);
			
			statement.setString(1,assetname);
			statement.setInt(2, empId);
			
			statement.executeQuery();
			
			statement = connection.prepareStatement(QueryConstant.fetchReqId);
			resultSet = statement.executeQuery();
			
			resultSet.next();
			
			result=resultSet.getInt(1);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	@Override
	public void reqStatus(int reqId) throws AssetException {
		connection = JdbcUtility.getConnection();
		
		try {
			statement = connection.prepareStatement(QueryConstant.fetchReqStatus);
			statement.setInt(1, reqId);
			resultSet = statement.executeQuery();
			resultSet.next();
		
			System.out.println("Current Status: "+resultSet.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	@Override
	public int viewQuantity(String assetName) throws AssetException {
		connection =JdbcUtility.getConnection();
		int quantity=0;
		try {
			statement=connection.prepareStatement(QueryConstant.getQuantity);
			statement.setString(1, assetName);
			resultSet=statement.executeQuery();
			if(resultSet.next())
			{
				quantity=resultSet.getInt(1);
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return quantity;
	}
	@Override
	public int decrementQuantity(String assetName) throws AssetException {
    connection=JdbcUtility.getConnection();
    int result=0;
    try {
		statement=connection.prepareStatement(QueryConstant.decreaseQuantity);
		statement.setString(1, assetName);
		  result =statement.executeUpdate();
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		
		return result;
	}
	@Override
	public int insertDetails(AssetsBean assetbean) throws AssetException {
		connection=JdbcUtility.getConnection();
		int insert=0;
		try {
			statement=connection.prepareStatement(QueryConstant.insertDetails);
			statement.setInt(1, assetbean.getAssetId());
			statement.setString(2, assetbean.getAssetName());
			statement.setInt(3, assetbean.getQuantity());
			statement.setString(4, assetbean.getStatus());
			insert=statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return insert;
	}
	@Override
	public int deleteAsset(String assetName) throws AssetException {
		connection=JdbcUtility.getConnection();
		int delete=0;
		try {
			statement=connection.prepareStatement(QueryConstant.deleteDetails);
			statement.setString(1, assetName);
			delete = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete;
	}
	@Override
	public int increaseQuantity(String assetName) throws AssetException {
      connection=JdbcUtility.getConnection();
      int thanu=0;
      try {
		statement=connection.prepareStatement(QueryConstant.increaseQuantity);
		statement.setString(1, assetName);
		thanu=statement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
		return thanu;
	}
	
	
	
}
