package com.donation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String name;
    
    @Email
    @NotBlank
    private String email;
    
    private String phoneNumber;
    
    @OneToMany(mappedBy = "donor")
    private List<Donation> donations = new ArrayList<>();
} 