package org.springboot.users.repository;

import org.springboot.users.entity.positionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface positionRepository extends CrudRepository<positionEntity, Integer> {

}
