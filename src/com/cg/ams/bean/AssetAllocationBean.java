package com.cg.ams.bean;


public class AssetAllocationBean {
	private int reqId;
	private String assetName;
	private int empNo;
	private String status;
	public AssetAllocationBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssetAllocationBean(int reqId, String assetName, int empNo,
			String status) {
		super();
		this.reqId = reqId;
		this.assetName = assetName;
		this.empNo = empNo;
		this.status = status;
	}
	public AssetAllocationBean(String assetName, int empNo) {
		super();
		this.assetName = assetName;
		this.empNo = empNo;
	}
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AssetAllocationBean [reqId=" + reqId + ", assetName="
				+ assetName + ", empNo=" + empNo + ", status=" + status + "]";
	}
	
	
}
