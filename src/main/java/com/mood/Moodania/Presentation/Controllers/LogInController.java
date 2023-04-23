package com.mood.Moodania.Presentation.Controllers;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.mood.Moodania.Presentation.Models.LogInUserAccountModel;
import com.mood.Moodania.Presentation.Models.SignUpUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.LogInDto;
import com.mood.Moodania.ServiceLayer.Services.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@RestController
@RequestMapping("/mood/v1/login")
public class LogInController {

    private final LogInService logInService;
    @Autowired
    public LogInController(LogInService logInService) {
        this.logInService = logInService;
    }

    @PostMapping
    public LogInDto logInDto(@RequestBody LogInUserAccountModel model){
        return logInService.LogIn(model);
    }
}
