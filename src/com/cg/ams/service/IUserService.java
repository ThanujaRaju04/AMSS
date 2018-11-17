package com.cg.ams.service;

import com.cg.ams.bean.AssetsBean;
import com.cg.ams.bean.EmployeeBean;
import com.cg.ams.bean.UserMasterBean;
import com.cg.ams.exceptions.AssetException;

public interface IUserService {



	/*boolean LoginValidate(String userName, String userPassword)throws AssetException;
*/
	boolean LoginValidate(UserMasterBean bean) throws AssetException;

	int Allocate(int empId, String assetname) throws AssetException;

	void reqStatus(int reqId) throws AssetException;

	int viewQuantity(String assetName) throws AssetException;

	int decrementQuantity(String assetName) throws AssetException;

	int insertDetails(AssetsBean assetbean) throws AssetException;

	int deleteAsset(String assetName) throws AssetException;

	int increaseQuantity(String assetName) throws AssetException;







	
}
