package com.example.examproj;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "donations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Positive
    private BigDecimal amount;
    
    @NotNull
    private LocalDateTime donationDate;
    
    @ManyToOne
    @JoinColumn(name = "donor_id", nullable = false)
    @JsonIgnoreProperties("donations")
    private Donor donor;
    
    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    @JsonIgnoreProperties("donations")
    private Campaign campaign;
} 