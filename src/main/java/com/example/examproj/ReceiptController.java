package com.example.examproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {
    private final ReceiptService receiptService;

    @Autowired
    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("/donor/{donorId}")
    public ResponseEntity<String> getDonorReceipt(@PathVariable Long donorId) {
        String receipt = receiptService.generateDonorReceipt(donorId);
        return ResponseEntity.ok(receipt);
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<String> getCampaignReceipt(@PathVariable Long campaignId) {
        String receipt = receiptService.generateCampaignReceipt(campaignId);
        return ResponseEntity.ok(receipt);
    }
} 