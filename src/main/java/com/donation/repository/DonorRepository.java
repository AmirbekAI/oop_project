package com.donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.donation.model.Donor;
import java.util.Optional;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
    Optional<Donor> findByEmail(String email);
} 