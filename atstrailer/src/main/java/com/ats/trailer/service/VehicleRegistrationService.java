package com.ats.trailer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.trailer.model.VehicleRegistrationDetails;
import com.ats.trailer.repository.VehicleRegistrationRepository;


@Service
public class VehicleRegistrationService {
	
	@Autowired
	VehicleRegistrationRepository vrr;
	
	public void saveVehicleRegistrationDetails(VehicleRegistrationDetails vrd) {
		vrr.save(vrd);
	}

	public int findOwnerIdByRegnNum(String regnNum) {
		return vrr.findOwnerIdByRegnNum(regnNum);
	}
	
	public VehicleRegistrationDetails getByVehicleRegistrationDetailsByOwnerId(int ownerId) {
		return vrr.findByOwnerId(ownerId);
	}
}
