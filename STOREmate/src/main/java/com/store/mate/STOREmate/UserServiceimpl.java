package com.store.mate.STOREmate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepo usersRepo;


    @Override
    public String addUser(UsersDTO usersDTO){

        // Check if email already exists
    if (usersRepo.findByEmail(usersDTO.getEmail()) != null) {
        return "Email already exists!";
    }

    // Check if phone already exists
    if (usersRepo.findByPhone(usersDTO.getPhone()).isPresent()) {
        return "Phone number already exists!";
    }

        UsersEntity usersEntity = new UsersEntity(); 
        usersEntity.setName(usersDTO.getName());
        usersEntity.setPhone(usersDTO.getPhone());
        usersEntity.setEmail(usersDTO.getEmail());
        usersEntity.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
        usersEntity.setAddress(usersDTO.getAddress());

        usersRepo.save(usersEntity);
        return "User registered successfully!";
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO){
        UsersEntity user = usersRepo.findByEmail(loginDTO.getEmail());
        if(user != null){
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if(isPwdRight){
                Optional<UsersEntity> users = usersRepo.findByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (users.isPresent()){ //built-in function in java for optional class
                    return new LoginMessage("Logged-in Successfully", true);
                }
                else{
                    return new LoginMessage("Login Failed", false);
                }
            }
            else{
                return new LoginMessage("Invalid Password", false);
            }
        }
        else{
            return new LoginMessage("User does not exists",false);
        }
    }
}