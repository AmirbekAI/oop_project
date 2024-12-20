package com.donation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "campaigns")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String title;
    
    private String description;
    
    @NotNull
    private LocalDateTime startDate;
    
    @NotNull
    private LocalDateTime endDate;
    
    @NotNull
    @Positive
    private BigDecimal targetAmount;
    
    @OneToMany(mappedBy = "campaign")
    private List<Donation> donations = new ArrayList<>();
} 