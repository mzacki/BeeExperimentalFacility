package com.bxf.persistence.dao;


import com.bxf.persistence.entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Matt on 09.04.2019 at 17:37.
 */

public interface WeatherDataRepository extends JpaRepository<WeatherData, Integer> {

}
