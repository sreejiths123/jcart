package com.labs.lawcart.matter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labs.lawcart.LawCartException;
import com.labs.lawcart.entities.Category;
import com.labs.lawcart.entities.Matter;
import com.labs.lawcart.entities.Order;
import com.labs.lawcart.entities.Product;


@Service
@Transactional
public class MatterService {

	@Autowired MatterRepository matterRepository;
	
	
	public List<Matter> getAllMatters() {
		
		return matterRepository.findAll();
	}
	
	
	public Matter createMatter(Matter matter) {
		
		if(matter != null){
			return matterRepository.save(matter);
		}else throw new LawCartException("Error while saving Matter...");
		
	}


	public Matter getMatterById(Integer matterId) {
	    
		if(matterId !=null){
			return matterRepository.getOne(matterId);
		}else throw new LawCartException("Error while retrieving Matter...");
		
	}


	public Matter updateMatter(Matter matter) {
		Matter persistedMatter = getMatterById(matter.getId());
		if(persistedMatter == null){
			throw new LawCartException("Product "+matter.getId()+" doesn't exist");
		}
		persistedMatter.setDescription(matter.getDescription());
		persistedMatter.setClientReferenceNo(matter.getClientReferenceNo());
		persistedMatter.setCloseDate(matter.getCloseDate());
		persistedMatter.setLocation(matter.getLocation());
		persistedMatter.setOpenDate(matter.getOpenDate());
		persistedMatter.setPendingDate(matter.getPendingDate());
		persistedMatter.setPracticeArea(matter.getPracticeArea());
		persistedMatter.setResponsibleAttorney(matter.getResponsibleAttorney());
		persistedMatter.setStatus(matter.getStatus());
		persistedMatter.setUser(matter.getUser());
		
		return matterRepository.save(persistedMatter);
		
	}
}
