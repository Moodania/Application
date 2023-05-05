package com.mood.Moodania.ServiceLayer.Services.Implementations;

import com.mood.Moodania.DataAccessLayer.Entities.RoleEntity;
import com.mood.Moodania.DataAccessLayer.Models.ERole;
import com.mood.Moodania.DataAccessLayer.Repositories.RoleRepository;
import com.mood.Moodania.ServiceLayer.Dto.RoleDto;
import com.mood.Moodania.ServiceLayer.Mapping.Mapper;
import com.mood.Moodania.ServiceLayer.Services.RoleServiceInterface;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements RoleServiceInterface {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto createNewRole(ERole role) throws ConstraintViolationException {
        RoleEntity roleEntity = new RoleEntity(role);
        RoleEntity newRole = roleRepository.save(roleEntity);
        return Mapper.toRoleDto(newRole);
    }
}
