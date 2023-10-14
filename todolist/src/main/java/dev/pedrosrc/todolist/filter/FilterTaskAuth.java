package dev.pedrosrc.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import dev.pedrosrc.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter{

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
             
            //Get Email and Password    
            var auth = request.getHeader("Authorization");
            var authEncoded = auth.substring("Basic".length()).trim();

            byte[] authDecoded = Base64.getDecoder().decode(authEncoded);
            var authString = new String(authDecoded);

            System.out.println(authEncoded);
            System.out.println(authString); 

            String[] credentials = authString.split(":");
            var email = credentials[0];
            var password = credentials[1];

            //Validate Email
            var emailCheck = this.userRepository.findByEmail(email);
            if(emailCheck == null){
                response.sendError(400);
            }else{
                //Validate Password
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), emailCheck.getPassword());
                
                if(passwordVerify.verified){
                    filterChain.doFilter(request, response);
                }else{
                    response.sendError(400);
                }
                
            }
            
        
        
    }
    
}
