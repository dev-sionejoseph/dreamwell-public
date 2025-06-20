package com.devsione.dreamwell.repository;

import com.devsione.dreamwell.entity.Dream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DreamRepository extends JpaRepository<Dream, UUID> {
    List<Dream> findByUserId (UUID userId);
}
