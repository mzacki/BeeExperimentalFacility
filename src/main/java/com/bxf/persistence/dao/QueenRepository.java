package com.bxf.persistence.dao;

import com.bxf.persistence.entity.Queen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Matt on 13.06.2019 at 18:13.
 */

@Repository
public interface QueenRepository extends JpaRepository<Queen, Long> {

}
