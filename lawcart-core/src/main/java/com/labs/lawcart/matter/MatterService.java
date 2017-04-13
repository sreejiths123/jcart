package com.labs.lawcart.matter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labs.lawcart.LawCartException;
import com.labs.lawcart.entities.Category;
import com.labs.lawcart.entities.Matter;


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
}
