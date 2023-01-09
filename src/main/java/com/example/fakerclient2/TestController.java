package com.example.fakerclient2;

import com.example.fakerclient2.client.UsersClient;
import com.example.fakerclient2.wsdl.GetUsersResponse;
import com.example.fakerclient2.wsdl.SoapUsers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/import")
public class TestController {
    private final UsersClient usersClient;

    public TestController(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    @GetMapping
    public ResponseEntity getAllUsers(){

        return ResponseEntity.ok().body(usersClient.getUsers());

    }
}
