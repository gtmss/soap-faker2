package com.example.fakerclient2.mapper;

import com.example.fakerclient2.model.Users;
import com.example.fakerclient2.wsdl.SoapUsers;
import org.mapstruct.Mapper;


@Mapper
public interface SimpleSourceDestinationMapper {
    SoapUsers usersToSoapUsers (Users users);
    Users soapUsersToUsers (SoapUsers soapUsers);
}
