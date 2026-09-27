package com.store.mate.STOREmate;



public interface UserService {
    
    String addUser(UsersDTO usersDTO);

    LoginMessage loginUser(LoginDTO loginDTO);

}

