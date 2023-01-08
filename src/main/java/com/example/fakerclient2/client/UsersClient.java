package com.example.fakerclient2.client;

import com.example.fakerclient2.wsdl.GetUserByIdRequest;
import com.example.fakerclient2.wsdl.GetUserByIdResponse;
import com.example.fakerclient2.wsdl.GetUsersRequest;
import com.example.fakerclient2.wsdl.GetUsersResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

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

}
