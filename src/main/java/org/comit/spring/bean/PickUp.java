package org.comit.spring.bean;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

public class PickUp {

	int idserviceRequest;
	
	
	String pickupDate;
	
	String pickupTime;
	String amPm;
	
	
	String deliveryTime;
	
	
	public int getIdserviceRequest() {
		return idserviceRequest;
	}
	public void setIdserviceRequest(int idserviceRequest) {
		this.idserviceRequest = idserviceRequest;
	}
	public String getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	public String getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}
	public String getAmPm() {
		return amPm;
	}
	public void setAmPm(String amPm) {
		this.amPm = amPm;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	@Override
	public String toString() {
		return "PickUp [idserviceRequest=" + idserviceRequest + ", pickupDate=" + pickupDate + ", pickupTime="
				+ pickupTime + ", amPm=" + amPm + ", deliveryTime=" + deliveryTime + "]";
	}
	
	
	
	
	
}
