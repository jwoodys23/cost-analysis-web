package com.jourdanwoodrich.model;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jourdanwoodrich on 9/4/16.
 */
public interface PartUpdateDao extends CrudRepository<PartUpdate, Long> {
    PartUpdate findFirstByOrderByAddedDesc();
}
