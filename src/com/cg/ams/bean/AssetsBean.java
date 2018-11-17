package com.cg.ams.bean;

public class AssetsBean {
	private int assetId;
	private String assetName;
	private String assetDes;
	private int quantity;
	private String status;

	public AssetsBean() {
		super();
	}

	public AssetsBean(int assetId, String assetName, String assetDes,
			int quantity, String status) {
		super();
		this.assetId = assetId;
		this.assetName = assetName;
		this.assetDes = assetDes;
		this.quantity = quantity;
		this.status = status;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetDes() {
		return assetDes;
	}

	public void setAssetDes(String assetDes) {
		this.assetDes = assetDes;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AssetsBean [assetId=" + assetId + ", assetName=" + assetName
				+ ", assetDes=" + assetDes + ", quantity=" + quantity
				+ ", status=" + status + "]";
	}

}
