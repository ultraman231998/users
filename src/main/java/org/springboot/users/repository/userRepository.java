package org.springboot.users.repository;

import java.util.List;

import org.springboot.users.entity.userEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends CrudRepository<userEntity, Integer> {
	@Query(value = "SELECT * FROM user u WHERE u.name = ?1", 
		       nativeQuery = true)
	List<userEntity> findName(String term);
	
	@Query(value = "SELECT * FROM user u LEFT JOIN position p ON u.position_id = p.id", nativeQuery = true)
	List<userEntity> getAll();
}
