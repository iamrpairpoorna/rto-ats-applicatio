package com.ats.trailer.model;




public class PerviewModel {
	
	private VehicleOwner vehicleOwner;
	private VehicleOwnerAddress vehicleOwnerAddress;
	private Vehicle_details vehicle_details;
	private VehicleRegistrationDetails details;
	
	
	public VehicleOwner getVehicleOwner() {
		return vehicleOwner;
	}
	public void setVehicleOwner(VehicleOwner vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}
	public VehicleOwnerAddress getVehicleOwnerAddress() {
		return vehicleOwnerAddress;
	}
	public void setVehicleOwnerAddress(VehicleOwnerAddress vehicleOwnerAddress) {
		this.vehicleOwnerAddress = vehicleOwnerAddress;
	}
	public Vehicle_details getVehicle_details() {
		return vehicle_details;
	}
	public void setVehicle_details(Vehicle_details vehicle_details) {
		this.vehicle_details = vehicle_details;
	}
	public VehicleRegistrationDetails getDetails() {
		return details;
	}
	public void setDetails(VehicleRegistrationDetails details) {
		this.details = details;
	}
	
	

}
