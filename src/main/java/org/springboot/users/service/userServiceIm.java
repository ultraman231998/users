package org.springboot.users.service;

import java.util.List;
import java.util.Optional;

import org.springboot.users.entity.userEntity;
import org.springboot.users.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceIm implements userService {
	@Autowired userRepository userRepository;

	@Override
	public List<userEntity> findAll() {
		return (List<userEntity>) userRepository.getAll();
	}
	
	@Override
	public Optional<userEntity> findById(Integer id) {
		return userRepository.findById(id);
	}
	
	@Override
	public void saveUser(userEntity userEntity) {
		userRepository.save(userEntity);
	}
	
	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public List<userEntity> search(String term) {
		return userRepository.findName(term);
	}
	
}
