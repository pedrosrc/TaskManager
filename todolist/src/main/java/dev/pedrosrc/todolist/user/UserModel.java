package dev.pedrosrc.todolist.user;

public class UserModel {
    
    private String name;
    private String email;
    private String password;

    // Get and Return parameter

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }

    // Get and Return parameter
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    // Get and Return parameter

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
