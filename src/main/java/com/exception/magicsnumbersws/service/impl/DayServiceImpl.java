package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.DayDao;
import com.exception.magicsnumbersws.entities.Category;
import com.exception.magicsnumbersws.entities.Day;
import com.exception.magicsnumbersws.exception.FindDayException;
import com.exception.magicsnumbersws.service.DayService;
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
public class DayServiceImpl implements  DayService{

    @Autowired
    private DayDao dayDao;

    public DayServiceImpl() {
    }
    
    @Transactional
    @Override
    public List<Day> findAll() throws FindDayException{
        return dayDao.findAll();
    }

    @Transactional
    @Override
    public Day findById(int dayId) throws FindDayException {
        return dayDao.findById(dayId);
    }
}
