package com.mood.Moodania.Presentation.Controllers;

import com.mood.Moodania.Presentation.Models.LogInUserAccountModel;
import com.mood.Moodania.Presentation.Models.SignUpUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;
import com.mood.Moodania.ServiceLayer.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mood/v1/account")
public class AccountController {
    private final AccountService accountService;
    @Autowired
    
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/signup")
    public AccountDto signUp(@RequestBody SignUpUserAccountModel model){
        return  accountService.signUp(model);
    }
    @PostMapping("/login")
    public AccountDto logInDto(@RequestBody LogInUserAccountModel model){
        return accountService.logIn(model);
    }

}
