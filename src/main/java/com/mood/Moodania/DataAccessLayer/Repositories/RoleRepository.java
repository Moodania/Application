package com.mood.Moodania.DataAccessLayer.Repositories;

import com.mood.Moodania.DataAccessLayer.Entities.RoleEntity;
import com.mood.Moodania.DataAccessLayer.Models.ERole;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<RoleEntity, UUID> {
    RoleEntity findByName(ERole role);
}
