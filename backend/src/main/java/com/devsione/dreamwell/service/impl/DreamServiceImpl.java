package com.devsione.dreamwell.service.impl;

import com.devsione.dreamwell.dto.DreamDTO;
import com.devsione.dreamwell.dto.UserDTO;
import com.devsione.dreamwell.entity.Dream;
import com.devsione.dreamwell.entity.User;
import com.devsione.dreamwell.mapper.DreamMapper;
import com.devsione.dreamwell.mapper.UserMapper;
import com.devsione.dreamwell.repository.DreamRepository;

import com.devsione.dreamwell.repository.UserRepository;
import com.devsione.dreamwell.service.DreamService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DreamServiceImpl implements DreamService {

    private final DreamRepository dreamRepository;
    private final DreamMapper dreamMapper;
    private final UserRepository userRepository;

    public DreamServiceImpl(DreamRepository dreamRepository, DreamMapper dreamMapper, UserRepository userRepository) {
        this.dreamRepository = dreamRepository;
        this.dreamMapper = dreamMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<DreamDTO> findAll(){
        List<Dream> dreams = dreamRepository.findAll();

        return dreams.stream()
                .map(dreamMapper::ToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DreamDTO newDream(DreamDTO dreamDTO) {
        User user = userRepository.findById(dreamDTO.getUserid())
                .orElseThrow(() -> new RuntimeException("Invalid User"));
        Dream dream = dreamMapper.ToEntity(dreamDTO,user);
        dreamRepository.save(dream);
        return dreamMapper.ToDTO(dream);
    }

    @Override
    public DreamDTO findByID(UUID dreamid) {
        Dream dream = dreamRepository.findById(dreamid)
                .orElseThrow(() -> new RuntimeException("Dream not found"));;
        return dreamMapper.ToDTO(dream);
    }

    @Override
    public List<DreamDTO> findByUser(UUID userid) {
        List<Dream> dreams = dreamRepository.findByUserId(userid);
        return dreams.stream()
                .map(dreamMapper::ToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDream(UUID dreamid) {
        if (!dreamRepository.existsById(dreamid)){
            throw new EntityNotFoundException("This dream does not exist");
        }
        dreamRepository.deleteById(dreamid);
    }
}
