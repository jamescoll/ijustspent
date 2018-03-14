package com.ijustspent.main.controllers.security;

import com.ijustspent.main.converters.ConverterFacade;
import com.ijustspent.main.dto.UserDTO;
import com.ijustspent.main.services.UserService;
import com.ijustspent.main.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/signup")
public class SignUpController {

    private final UserService service;

    private final ConverterFacade converterFacade;

    @Autowired
    public SignUpController(final UserService service,
                            final ConverterFacade converterFacade) {
        this.service = service;
        this.converterFacade = converterFacade;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody final UserDTO dto) {
        return new ResponseEntity<>(service.create(converterFacade.convert(dto)), HttpStatus.OK);
    }
}
