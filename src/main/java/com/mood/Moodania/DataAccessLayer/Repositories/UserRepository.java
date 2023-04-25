package com.mood.Moodania.DataAccessLayer.Repositories;

import com.mood.Moodania.DataAccessLayer.Entities.UserEntity;
import org.springframework.core.annotation.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Component
public interface UserRepository extends CrudRepository<UserEntity, UUID> {

}
