package com.colony.persistence.service;

import com.colony.exception.NotFoundException;
import com.colony.persistence.dao.BeehiveRepository;
import com.colony.persistence.entity.Beehive;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by Matt on 13.06.2019 at 18:53.
 */

@Primary
@Service
public class BeehiveServiceImplementation implements BeehiveService {

    private final BeehiveRepository beehiveRepository;

    @Autowired
    public BeehiveServiceImplementation(BeehiveRepository beehiveRepository) {
        this.beehiveRepository = beehiveRepository;
    }

    @Override
    public List<Beehive> findAll() {
        return beehiveRepository.findAll();
    }


    @Override
    public List<Beehive> findAllNucs() {
        return beehiveRepository.findAllNucs();
    }

    @Override
    public Beehive findByID(long id) {
        return beehiveRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Beehive hasn't found"));
    }

    @Override
    public void save(Beehive beehive) {
        beehiveRepository.save(beehive);
    }

    @Override
    public void deleteByID(long id) {
        beehiveRepository.deleteById(id);
    }

}
