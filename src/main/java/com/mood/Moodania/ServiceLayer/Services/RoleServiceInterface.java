package com.mood.Moodania.ServiceLayer.Services;

import com.mood.Moodania.DataAccessLayer.Models.ERole;
import com.mood.Moodania.ServiceLayer.Dto.RoleDto;
import org.hibernate.exception.ConstraintViolationException;

public interface RoleServiceInterface {

    RoleDto createNewRole(ERole role) throws ConstraintViolationException;
}
