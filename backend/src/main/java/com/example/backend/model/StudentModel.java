package com.example.backend.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentModel {
    private String Id;
    private String Name;
    private String Email;

    @NotBlank(message = "ID is required")
    @Size(max = 10, message = "ID must be at most 10 characters long")

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be at most 50 characters long")

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")

    
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
}