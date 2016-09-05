package com.jourdanwoodrich.service;

import com.jourdanwoodrich.model.PartUpdate;
import com.jourdanwoodrich.model.PartUpdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jourdanwoodrich on 9/4/16.
 */

@Service
public class PartUpdateService {

    @Autowired
    private PartUpdateDao partUpdateDao;

    public void save(PartUpdate partUpdate){
        partUpdateDao.save(partUpdate);
    }

    public PartUpdate getLatest(){
        return partUpdateDao.findFirstByOrderByAddedDesc();
    }
}
