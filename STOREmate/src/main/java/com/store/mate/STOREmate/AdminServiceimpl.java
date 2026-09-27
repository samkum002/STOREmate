package com.store.mate.STOREmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceimpl implements AdminService{
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AdminRepo adminrepo;

    @Override
    public LoginMessage loginAdmin(LoginDTO loginDTO){
        AdminEntity admin = adminrepo.findByEmail(loginDTO.getEmail());
        if(admin!=null){
            String enteredpassword = loginDTO.getPassword();
            String hashedpassword = admin.getPassword();
            Boolean ispwdright = passwordEncoder.matches(enteredpassword,hashedpassword);
            if(ispwdright){
                return new LoginMessage("Logged-in Successfully", true);
            }
            else{
                return new LoginMessage("Invalid Password", false);
            }
        }
        else{
            return new LoginMessage("Admin does not exist", false);
        }

    }
}
