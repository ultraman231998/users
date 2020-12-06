package org.springboot.users.service;

import java.util.List;

import org.springboot.users.entity.positionEntity;
import org.springboot.users.repository.positionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class positionServiceIm implements positionService {
	@Autowired positionRepository positionRepository;
	
	public List<positionEntity> getAll() {
		return (List<positionEntity>) positionRepository.findAll();
	}

}
