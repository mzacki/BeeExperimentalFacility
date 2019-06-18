package com.colony.persistence.dao;

import com.colony.persistence.entity.Beehive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Matt on 13.06.2019 at 18:11.
 */

@Repository
public interface BeehiveRepository extends JpaRepository<Beehive, Long> {
}
