package com.mood.Moodania.Presentation.Controllers;

import com.mood.Moodania.Presentation.Models.SignUpUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.SignUpDto;
import com.mood.Moodania.ServiceLayer.Services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mood/v1/signup")
public class SignUpController {
    private final SignUpService signUpService;
    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PostMapping
    public SignUpDto signUp(@RequestBody SignUpUserAccountModel model){
        return  signUpService.signUp(model);
    }
}
