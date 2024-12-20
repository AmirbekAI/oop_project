package com.donation.service;

import com.donation.model.Donation;
import com.donation.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DonationService {
    private final DonationRepository donationRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Donation save(Donation donation) {
        return donationRepository.save(donation);
    }

    public Optional<Donation> findById(Long id) {
        return donationRepository.findById(id);
    }

    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    public List<Donation> findByCampaignId(Long campaignId) {
        return donationRepository.findByCampaignId(campaignId);
    }

    public List<Donation> findByDonorId(Long donorId) {
        return donationRepository.findByDonorId(donorId);
    }

    public void deleteById(Long id) {
        donationRepository.deleteById(id);
    }
} 