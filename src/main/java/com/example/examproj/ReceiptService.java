package com.example.examproj;

import com.example.examproj.Donation;
import com.example.examproj.Donor;
import com.example.examproj.DonationRepository;
import com.example.examproj.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {
    private final DonationRepository donationRepository;
    private final DonorRepository donorRepository;

    @Autowired
    public ReceiptService(DonationRepository donationRepository, DonorRepository donorRepository) {
        this.donationRepository = donationRepository;
        this.donorRepository = donorRepository;
    }

    public String generateDonorReceipt(Long donorId) {
        Optional<Donor> donorOpt = donorRepository.findById(donorId);
        if (donorOpt.isEmpty()) {
            return "Donor not found";
        }

        Donor donor = donorOpt.get();
        List<Donation> donations = donationRepository.findByDonorId(donorId);
        
        StringBuilder receipt = new StringBuilder();
        BigDecimal totalDonated = BigDecimal.ZERO;

        receipt.append("=== DONATION RECEIPT ===\n\n");
        receipt.append("Donor Information:\n");
        receipt.append("Name: ").append(donor.getName()).append("\n");
        receipt.append("Email: ").append(donor.getEmail()).append("\n");
        receipt.append("Phone: ").append(donor.getPhoneNumber()).append("\n\n");
        
        receipt.append("Donation History:\n");
        receipt.append("----------------\n");

        for (Donation donation : donations) {
            receipt.append("Date: ").append(donation.getDonationDate().toString()).append("\n");
            receipt.append("Campaign: ").append(donation.getCampaign().getTitle()).append("\n");
            receipt.append("Amount: $").append(donation.getAmount()).append("\n");
            receipt.append("----------------\n");
            
            totalDonated = totalDonated.add(donation.getAmount());
        }

        receipt.append("\nTotal Donations: $").append(totalDonated).append("\n");
        receipt.append("Number of Donations: ").append(donations.size()).append("\n");
        receipt.append("\nThank you for your generous support!");

        return receipt.toString();
    }

    public String generateCampaignReceipt(Long campaignId) {
        List<Donation> donations = donationRepository.findByCampaignId(campaignId);
        if (donations.isEmpty()) {
            return "No donations found for this campaign";
        }

        StringBuilder receipt = new StringBuilder();
        BigDecimal totalReceived = BigDecimal.ZERO;

        // Get campaign details from the first donation
        var campaign = donations.get(0).getCampaign();

        receipt.append("=== CAMPAIGN DONATION SUMMARY ===\n\n");
        receipt.append("Campaign: ").append(campaign.getTitle()).append("\n");
        receipt.append("Description: ").append(campaign.getDescription()).append("\n");
        receipt.append("Target Amount: $").append(campaign.getTargetAmount()).append("\n\n");
        
        receipt.append("Donations Received:\n");
        receipt.append("----------------\n");

        for (Donation donation : donations) {
            receipt.append("Donor: ").append(donation.getDonor().getName()).append("\n");
            receipt.append("Amount: $").append(donation.getAmount()).append("\n");
            receipt.append("Date: ").append(donation.getDonationDate().toString()).append("\n");
            receipt.append("----------------\n");
            
            totalReceived = totalReceived.add(donation.getAmount());
        }

        receipt.append("\nTotal Received: $").append(totalReceived).append("\n");
        receipt.append("Progress: ").append(totalReceived.multiply(new BigDecimal(100))
                .divide(campaign.getTargetAmount(), 2, BigDecimal.ROUND_HALF_UP))
                .append("%\n");
        receipt.append("Number of Donors: ").append(donations.size()).append("\n");

        return receipt.toString();
    }
} 