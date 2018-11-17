package com.cg.ams.dao;

public interface QueryConstant {
 public static final String  fetchUser=" select userName, userpassword from User_Master where userType=?";
 public static final String  ReqTableUpdate=" insert into assetallocation values(requestid.nextval,?,?,'Request Pending')";
 public static final String  fetchReqId="select requestid.currval from dual";
 public static final String  fetchReqStatus="select status from assetallocation where reqid=?";
public static final String getQuantity = "select quantity from Asset where assetName=?";
public static final String decreaseQuantity = "update asset set quantity=quantity-1 where assetname=?";
public static final String insertDetails = "insert into Asset values(?,?,?,?)";
public static final String deleteDetails = "delete from asset where assetName=?";
public static final String increaseQuantity = "update asset set quantity=quantity+1 where assetname=?";

}
