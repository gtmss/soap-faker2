package com.example.fakerclient2.services;

import com.example.fakerclient2.mapper.SimpleSourceDestinationMapper;
import com.example.fakerclient2.model.Users;
import com.example.fakerclient2.repository.UsersRepository;
import com.example.fakerclient2.wsdl.GetUsersResponse;
import com.example.fakerclient2.wsdl.SoapUsers;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class ResponseToUsersDatabase{


    private final UsersRepository usersRepository;

    private SimpleSourceDestinationMapper mapper
            = Mappers.getMapper(SimpleSourceDestinationMapper.class);

    public ResponseToUsersDatabase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public List<SoapUsers> toDatabase (GetUsersResponse response){


        List<SoapUsers> usersList = response.getUsers();
        List<Users> usersModel = new ArrayList<>();
        usersList.forEach(users -> usersModel.add(mapper.soapUsersToUsers(users)));
        usersRepository.saveAll(usersModel);
        //usersModel.forEach(users -> usersRepository.save(users));

        return usersList;
    }


}
