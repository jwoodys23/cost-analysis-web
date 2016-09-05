package com.jourdanwoodrich.model;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jourdanwoodrich on 9/4/16.
 */
public interface PartUpdateDao extends PagingAndSortingRepository<PartUpdate, Long> {
    PartUpdate findFirstByOrderByAddedDesc();
}
