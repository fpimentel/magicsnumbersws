package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.TimeDao;
import com.exception.magicsnumbersws.entities.Time;
import com.exception.magicsnumbersws.exception.FindTimeException;
import com.exception.magicsnumbersws.service.TimeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 25-sept-2013
 */
@Service
public class TimeServiceImpl implements  TimeService{

    @Autowired
    private TimeDao timeDao;

    public TimeServiceImpl() {
    }

    @Transactional
    @Override
    public List<Time> findAll() throws FindTimeException {
        return timeDao.findAll();
    }        
}
