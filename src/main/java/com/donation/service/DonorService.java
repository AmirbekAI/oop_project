package com.donation.service;

import com.donation.model.Donor;
import com.donation.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DonorService {
    private final DonorRepository donorRepository;

    @Autowired
    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    public Donor save(Donor donor) {
        return donorRepository.save(donor);
    }

    public Optional<Donor> findById(Long id) {
        return donorRepository.findById(id);
    }

    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    public void deleteById(Long id) {
        donorRepository.deleteById(id);
    }
} 