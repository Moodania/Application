package com.mood.Moodania.Presentation.Controllers;

import com.mood.Moodania.Presentation.Models.RequestModels.AuthenticationModels.LogInRequestModel;
import com.mood.Moodania.Presentation.Models.RequestModels.AuthenticationModels.SignUpRequestModel;
import com.mood.Moodania.Presentation.Models.ResponseModels.AuthenticationModels.SuccessfulLoginOrSignUpModel;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;
import com.mood.Moodania.ServiceLayer.Exceptions.AlreadyExistExceptions.EmailAlreadyExistException;
import com.mood.Moodania.ServiceLayer.Exceptions.InvalidExceptions.InvalidPasswordOrUsernameException;
import com.mood.Moodania.ServiceLayer.Services.Implementations.AuthenticationService;
import com.mood.Moodania.ServiceLayer.Services.Implementations.JwtService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mood/v1/authentication")
@PermitAll

public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("signup")
    public ResponseEntity<SuccessfulLoginOrSignUpModel> signUp(@RequestBody SignUpRequestModel model) throws EmailAlreadyExistException {
        AccountDto account = authenticationService.signUp(model.getEmail(), model.getUsername(), model.getPassword(), model.getRegion(), model.getBirthday());
        return ResponseEntity.ok(createSuccessfulLoginOrSignInModel(account));
    }

    @PostMapping("login")
    public ResponseEntity<SuccessfulLoginOrSignUpModel> logIn(@RequestBody LogInRequestModel model) throws InvalidPasswordOrUsernameException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(model.getEmail(), model.getPassword()));
        AccountDto account = authenticationService.logIn(model.getEmail(), model.getPassword());
        return ResponseEntity.ok(createSuccessfulLoginOrSignInModel(account));
    }

    private SuccessfulLoginOrSignUpModel createSuccessfulLoginOrSignInModel(AccountDto account) {
        String token = jwtService.createToken(account.email(), account.accountId(), account.Role());
        return new SuccessfulLoginOrSignUpModel(token, account.username());
    }
}
