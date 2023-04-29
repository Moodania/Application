package com.mood.Moodania.Presentation.Controllers;

import com.mood.Moodania.Presentation.Models.AccountModels.SignUpUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;
import com.mood.Moodania.ServiceLayer.Exceptions.AlreadyExistExceptions.EmailAlreadyExistException;
import com.mood.Moodania.ServiceLayer.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;

@RestController
@RequestMapping("/mood/v1/account")
public class AccountController {
    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("signup")
    public ResponseEntity<AccountDto> signUp(@RequestBody SignUpUserAccountModel model)
            throws EmailAlreadyExistException {
        try {
            AccountDto account = accountService.signUp(model.getEmail(), model.getUsername(), model.getPassword(), model.getRegion(), model.getBirthday());
            return ResponseEntity.ok(account);
        }
        catch (EmailAlreadyExistException e)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }
    /*@PostMapping("login")
    public AccountDto logIn(@RequestBody LogInUserAccountModel model){
        return accountService.logIn(model);
    }*/

}
