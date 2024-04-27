package org.comit.spring.bean;


public class ServiceType {
	
    			int idServiceType;
    			String Type;
    			String serviceName;
    			double Cost;
    			String Status;
    			
    			
				public int getIdServiceType() {
					return idServiceType;
				}
				public void setIdServiceType(int idServiceType) {
					this.idServiceType = idServiceType;
				}
				public String getType() {
					return Type;
				}
				public void setType(String type) {
					Type = type;
				}
				public String getServiceName() {
					return serviceName;
				}
				public void setServiceName(String serviceName) {
					this.serviceName = serviceName;
				}
				public double getCost() {
					return Cost;
				}
				public void setCost(double cost) {
					Cost = cost;
				}
				public String getStatus() {
					return Status;
				}
				public void setStatus(String status) {
					Status = status;
				}
    			
    			
}
