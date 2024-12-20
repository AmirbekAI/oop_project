package com.example.examproj;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findByEndDateAfter(LocalDateTime date);
    List<Campaign> findByTargetAmountGreaterThan(BigDecimal amount);
} 