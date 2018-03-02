package com.budgetmaster.main.controllers.security;

import com.budgetmaster.main.dto.LoginDTO;
import com.budgetmaster.main.dto.TokenDTO;
import com.budgetmaster.main.security.service.TokenService;
import com.budgetmaster.main.services.LoggedInUserService;
import com.budgetmaster.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private LoggedInUserService loggedInUserService;

    @Autowired
    public AuthenticationController(final TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody final LoginDTO dto) {
        final String token = tokenService.getToken(dto.getUsername(), dto.getPassword());
        if (token != null) {
            final TokenDTO response = new TokenDTO();
            response.setToken(token);
            loggedInUserService.setLoggedInUser(dto.getUsername());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    public ResponseEntity<?> deauthenticate() {
        final String response = "Logged Out Successfully";
        loggedInUserService.logOut();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
