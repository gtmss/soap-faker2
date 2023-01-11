package com.example.fakerclient2;

import com.example.fakerclient2.client.UsersClient;
import com.example.fakerclient2.repository.UsersRepository;
import com.example.fakerclient2.services.ResponseToUsersDatabase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/import")
public class TestController {
    private final UsersClient usersClient;

    private final UsersRepository usersRepository;


    public TestController(UsersClient usersClient, UsersRepository usersRepository) {
        this.usersClient = usersClient;
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        ResponseToUsersDatabase responseToUsersDatabase = new ResponseToUsersDatabase(usersRepository);
        //responseToUsersDatabase.toDatabase(usersClient.getUsers());
        return ResponseEntity.ok().body(usersClient.getUsers());

    }
}
