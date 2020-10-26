package com.colony.persistence.service;

import com.colony.persistence.entity.Beehive;

import java.util.List;

/**
 * Created by Matt on 13.06.2019 at 18:45.
 */

public interface BeehiveService {

    List<Beehive> findAll();
    Beehive findByID(long id);
    void save(Beehive beehive);
    void deleteByID(long id);
    List<Beehive> findAllNucs();

}
