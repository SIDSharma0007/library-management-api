package com.library.library_management.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // Imported for the @Table annotation
@Entity
@Table(name = "app_users") // Bypasses the database "USER" keyword crash
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    // --- Empty Constructor ---
    public User() {
    }
    // --- Getters and Setters ---
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }
    public String getName() { 
        return name; 
    }
    // Added the missing setName method
    public void setName(String name) { 
        this.name = name; 
    }
    public String getEmail() { 
        return email; 
    }
    // Fixed the parameter mismatch (was String title)
    public void setEmail(String email) { 
        this.email = email; 
    }
}