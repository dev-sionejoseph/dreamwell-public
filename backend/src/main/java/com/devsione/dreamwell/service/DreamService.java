package com.devsione.dreamwell.service;

import com.devsione.dreamwell.dto.DreamDTO;

import java.util.List;
import java.util.UUID;

public interface DreamService {
    DreamDTO newDream(DreamDTO dreamDTO);
    DreamDTO findByID(UUID dreamid);
    List<DreamDTO> findByUser(UUID userid);
    void deleteDream(UUID entryid);
    List<DreamDTO> findAll();
}
