package com.store.mate.STOREmate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class UsersEntity {  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;  

    @Column(nullable = false)  
    @NotBlank(message = "Name is required")  
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces")  
    private String name;  

    @Column(nullable = false)  
    @NotBlank(message = "Phone number is required")  
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be exactly 10 digits")  
    private String phone;  

    @NotBlank(message = "Email is required")  
    @Email(message = "Invalid email format")  
    @Column(nullable = false)  
    private String email;  

    @NotBlank(message = "Password is required")  
    @Size(min = 6, message = "Password must be at least 6 characters long")  
    @Column(nullable = false)  
    private String password;  

    @NotBlank(message = "Address is required")  
    private String address;  
}
