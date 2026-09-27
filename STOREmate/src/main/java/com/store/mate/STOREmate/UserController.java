package com.store.mate.STOREmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;




@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class UserController {
    

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UsersDTO userDTO, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        // Return the first validation error message
        String errorMessage = bindingResult.getFieldError().getDefaultMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }
    String message = userService.addUser(userDTO);
    return ResponseEntity.ok(message);
}


    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginDTO loginDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
    
        LoginMessage loginMessage = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }
    
    
}

