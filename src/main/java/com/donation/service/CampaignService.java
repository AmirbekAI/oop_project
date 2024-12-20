package com.donation.service;

import com.donation.model.Campaign;
import com.donation.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CampaignService {
    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public Campaign save(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public Optional<Campaign> findById(Long id) {
        return campaignRepository.findById(id);
    }

    public List<Campaign> findAll() {
        return campaignRepository.findAll();
    }

    public List<Campaign> findActiveCampaigns() {
        return campaignRepository.findByEndDateAfter(LocalDateTime.now());
    }

    public void deleteById(Long id) {
        campaignRepository.deleteById(id);
    }
} 