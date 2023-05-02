package com.mood.Moodania.Presentation.Controllers;


import com.mood.Moodania.Presentation.Models.RequestModels.RoleModels.RoleModel;
import com.mood.Moodania.ServiceLayer.Dto.RoleDto;
import com.mood.Moodania.ServiceLayer.Services.Implementations.RoleService;
import com.mood.Moodania.ServiceLayer.Services.RoleServiceInterface;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mood/v1/role")

public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("create-new")
    public ResponseEntity<RoleDto> createNew(@RequestBody RoleModel model) {
        RoleDto role = roleService.createNewRole(model.getRole());
        return ResponseEntity.ok(role);
    }
}
