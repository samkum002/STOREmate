package com.store.mate.STOREmate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Admin")
public class AdminEntity {

    @Id
    @NotBlank(message = "Email is required")  
    @Email(message = "Invalid email format")  
    @Column(nullable = false, unique = true)  
    private String email;  

    @NotBlank(message = "Password is required")  
    @Size(min = 6, message = "Password must be at least 6 characters long")  
    @Column(nullable = false)  
    private String password;
}
