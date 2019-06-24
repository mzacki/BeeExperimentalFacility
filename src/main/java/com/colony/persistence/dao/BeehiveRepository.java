package com.colony.persistence.dao;

import com.colony.persistence.entity.Beehive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Matt on 13.06.2019 at 18:11.
 */

@Repository
public interface BeehiveRepository extends JpaRepository<Beehive, Long> {

    @Query("SELECT b FROM Beehive b WHERE b.nuc = true")
    List<Beehive> findAllNucs();
}
