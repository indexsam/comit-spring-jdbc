package org.comit.spring.bean;

public class Order {
		
	int IdOrder;
	String ServiceName;
	String Type;
	double Cost;
	
	public int getIdOrder() {
		return IdOrder;
	}
	public void setIdOrder(int idOrder) {
		IdOrder = idOrder;
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
