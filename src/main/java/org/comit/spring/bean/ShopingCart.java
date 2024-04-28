package org.comit.spring.bean;

public class ShopingCart {

	int IdShopingCart;
	String ServiceName;
	String Type;
	double Cost;
	public int getIdShopingCart() {
		return IdShopingCart;
	}
	public void setIdShopingCart(int idShopingCart) {
		IdShopingCart = idShopingCart;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public double getCost() {
		return Cost;
	}
	public void setCost(double cost) {
		Cost = cost;
	}
	
	
}
