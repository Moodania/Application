package com.mood.Moodania.Presentation.Models.RequestModels.RoleModels;

import com.mood.Moodania.DataAccessLayer.Models.ERole;
import org.springframework.lang.NonNull;

public class RoleModel {
    private ERole role;

    public RoleModel() {
    }

    public RoleModel(ERole role) {
        this.role = role;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}