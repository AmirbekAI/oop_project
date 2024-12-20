package com.donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.donation.model.Donation;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByCampaignId(Long campaignId);
    List<Donation> findByDonorId(Long donorId);
} 