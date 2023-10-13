package dev.pedrosrc.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* 
// Modificadores \\
    Public
    Privade
    Protected
*/

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;
    
    @PostMapping("/register")
    public ResponseEntity create(@RequestBody UserModel userModel){
        var userExist = this.userRepository.findByEmail(userModel.getEmail());
        
        if (userExist != null){
            return ResponseEntity.status(400).body("Email Exist, Try New Email");
        }
        
        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(201).body(userCreated);    
    }
}
