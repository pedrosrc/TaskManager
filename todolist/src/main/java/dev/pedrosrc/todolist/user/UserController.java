package dev.pedrosrc.todolist.user;

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
    
    @PostMapping("/register")
    public void create(@RequestBody UserModel userModel){
        System.out.println(userModel.name);
    }
}
