package com.example.fakerclient2.client;

import com.example.fakerclient2.model.Users;
import com.example.fakerclient2.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.ArrayList;
import java.util.List;

public class UsersClient extends WebServiceGatewaySupport {

    private final Logger logger = LoggerFactory.getLogger(UsersClient.class);

    public GetUserByIdResponse getUsersById(Long id){
        GetUserByIdRequest request = new GetUserByIdRequest();
        request.setId(id);

        logger.info("Requested User with ID: {}", id);

        GetUserByIdResponse response = (GetUserByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/users"
                , request, new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetUsersByIdRequest"));

        return response;
    }

    public GetUsersResponse getUsers(){
        GetUsersRequest request = new GetUsersRequest();
        GetUsersResponse response = (GetUsersResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/users"
                        , request, new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetUsersByIdRequest"));

        return response;

    }

    public List<SoapUsers> converted (){
        List<SoapUsers> usersList = new ArrayList<>();
        GetUsersResponse response = new GetUsersResponse();
        usersList = response.getUsers();
        return usersList;
    }

}
