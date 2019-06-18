package com.colony.persistence.service;

import com.colony.persistence.dao.BeehiveRepository;
import com.colony.persistence.entity.Beehive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Matt on 13.06.2019 at 18:53.
 */

@Primary
@Service
public class BeehiveServiceImplementation implements BeehiveService {

    private BeehiveRepository beehiveRepository;

    @Autowired
    public BeehiveServiceImplementation(BeehiveRepository beehiveRepository) {
        this.beehiveRepository = beehiveRepository;
    }

    @Override
    public List<Beehive> findAll() {
        return beehiveRepository.findAll();
    }

    // how te get only nucs
    /*@Override
    public List<Beehive> getEnabled() {
        return
    }*/

    @Override
    public Beehive findByID(long id) {
        Optional<Beehive> result = beehiveRepository.findById(id);
        Beehive beehive = null;
        if (result.isPresent()) {
            beehive = result.get();
        } else {
            throw new RuntimeException("Beehive hasn't found.");
        }
        return beehive;
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
