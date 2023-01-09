package com.example.fakerclient2.services;

import com.example.fakerclient2.model.Users;
import com.example.fakerclient2.wsdl.GetUsersResponse;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class ResponseToUsersConverter implements Converter<GetUsersResponse, List<Users>> {

    @Override
    public List<Users> convert(GetUsersResponse source) {
        List<Users> usersList = new ArrayList<>();
        source.hashCode();
        
        return null;
    }


}
