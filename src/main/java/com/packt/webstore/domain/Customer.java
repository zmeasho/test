package com.packt.webstore.domain;

public class Customer {
 private String coustomerId;
 private  String name ;
 private String Address;
 private int noOfOrdersMade;
public Customer() {
	
}
public Customer(String coustomerId, String name, String address,
		int noOfOrdersMade) {
	
	this.coustomerId = coustomerId;
	this.name = name;
	Address = address;
	this.noOfOrdersMade = noOfOrdersMade;
}
public String getCoustomerId() {
	return coustomerId;
}
public void setCoustomerId(String coustomerId) {
	this.coustomerId = coustomerId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public int getNoOfOrdersMade() {
	return noOfOrdersMade;
}
public void setNoOfOrdersMade(int noOfOrdersMade) {
	this.noOfOrdersMade = noOfOrdersMade;
}
 
}
