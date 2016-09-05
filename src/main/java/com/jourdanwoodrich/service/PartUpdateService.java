package com.jourdanwoodrich.service;

import com.jourdanwoodrich.model.PartUpdate;
import com.jourdanwoodrich.model.PartUpdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by jourdanwoodrich on 9/4/16.
 */

@Service
public class PartUpdateService {

    private final static int PAGESIZE = 20;

    @Autowired
    private PartUpdateDao partUpdateDao;

    public void save(PartUpdate partUpdate){
        partUpdateDao.save(partUpdate);
    }

    public PartUpdate getLatest(){
        return partUpdateDao.findFirstByOrderByAddedDesc();
    }

    public Page<PartUpdate> getPage(int pageNumber){
        PageRequest request = new PageRequest(pageNumber-1, PAGESIZE, Sort.Direction.DESC, "added");
        return partUpdateDao.findAll(request);
    }
}
