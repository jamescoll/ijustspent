package com.ijustspent.main.converters;

import com.ijustspent.main.converters.factory.ConverterFactory;
import com.ijustspent.main.dto.UserDTO;
import com.ijustspent.main.models.security.User;
import com.ijustspent.main.converters.factory.ConverterFactory;
import com.ijustspent.main.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConverterFacade {

    @Autowired
    private ConverterFactory converterFactory;

    public User convert(final UserDTO dto) {
        return (User) converterFactory.getConverter(dto.getClass()).convert(dto);
    }
}
