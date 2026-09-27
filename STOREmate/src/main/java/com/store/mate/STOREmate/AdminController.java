package com.store.mate.STOREmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceimpl adminService;

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@Valid @RequestBody LoginDTO loginDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldError() != null
                ? bindingResult.getFieldError().getDefaultMessage()
                : "Invalid admin login details";
            return ResponseEntity.badRequest().body(errorMessage);
        }

        LoginMessage loginMessage = adminService.loginAdmin(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }
}
