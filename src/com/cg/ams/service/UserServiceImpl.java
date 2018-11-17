package com.cg.ams.service;

import com.cg.ams.bean.AssetsBean;
import com.cg.ams.bean.EmployeeBean;
import com.cg.ams.bean.UserMasterBean;
import com.cg.ams.dao.IUserDao;
import com.cg.ams.dao.UserDaoImpl;
import com.cg.ams.exceptions.AssetException;

public class UserServiceImpl implements IUserService {
	IUserDao userdao = new UserDaoImpl();

	@Override
	public boolean LoginValidate(UserMasterBean bean) throws AssetException {
		// TODO Auto-generated method stub
		 return userdao.LoginValidate(bean);
	}

	

	@Override
	public int Allocate(int empId, String assetname) throws AssetException {
		return userdao.Allocate(empId, assetname);
	}



	@Override
	public void reqStatus(int reqId) throws AssetException {
		userdao.reqStatus(reqId);
		
	}



	@Override
	public int viewQuantity(String assetName) throws AssetException {
		// TODO Auto-generated method stub
		return userdao.viewQuantity(assetName);
	}



	@Override
	public int decrementQuantity(String assetName) throws AssetException {
		// TODO Auto-generated method stub
		return userdao.decrementQuantity(assetName);
	}



	@Override
	public int insertDetails(AssetsBean assetbean) throws AssetException {
		// TODO Auto-generated method stub
		return userdao.insertDetails(assetbean);
	}



	@Override
	public int deleteAsset(String assetName) throws AssetException {
		// TODO Auto-generated method stub
		return userdao.deleteAsset(assetName);
	}



	@Override
	public int increaseQuantity(String assetName) throws AssetException {
		// TODO Auto-generated method stub
		return userdao.increaseQuantity(assetName);
	}



	






	
	/*@Override
	public boolean LoginValidate(String userName, String userPassword)
			throws AssetException {
		return userdao.LoginValidate(userName,userPassword);		
	}
*/

	
}
