package com.ats.trailer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.trailer.model.VehicleOwner;
import com.ats.trailer.repository.VehicleOwnerRepository;


@Service
public class VehicleOwnerService {
	
	
	@Autowired
	VehicleOwnerRepository<VehicleOwner> vehicleOwnerRepo;
	
	@Transactional
	public void saveVehicleOwner(VehicleOwner vehicleOwner) {
		System.out.println("in owner service:"+vehicleOwner.getOwner_fname());
		vehicleOwnerRepo.save(vehicleOwner);
	}
	
	public int getLastId() {
		return vehicleOwnerRepo.findTopByOrderByOwner_idDesc();
	}

	public VehicleOwner getByOwnerDetailsByOwnerId(int ownerId) {
		return (VehicleOwner)vehicleOwnerRepo.findByOwnerId(ownerId);
	}
}
