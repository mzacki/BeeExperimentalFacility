package com.colony.persistence.service;

import com.colony.persistence.dao.QueenRepository;
import com.colony.persistence.entity.Queen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matt on 18.06.2019 at 20:34.
 */

@Primary
@Service
public class QueenServiceImplementation implements QueenService {

    QueenRepository queenRepository;

    @Autowired
    public QueenServiceImplementation(QueenRepository queenRepository) {
        this.queenRepository = queenRepository;
    }

    @Override
    public List<Queen> findAll() {
        return queenRepository.findAll();
    }
}
