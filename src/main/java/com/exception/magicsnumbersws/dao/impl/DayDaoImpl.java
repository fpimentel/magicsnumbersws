package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.DayDao;
import com.exception.magicsnumbersws.entities.Day;
import com.exception.magicsnumbersws.exception.FindDayException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 */
@Repository
public class DayDaoImpl implements DayDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(DayDaoImpl.class.getName());

    public DayDaoImpl() {
    }

    public DayDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Day> findAll() throws FindDayException {
        try {
            List<Day> days = sessionFactory.getCurrentSession()
                    .createCriteria(Day.class)
                    .list();
            return days;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new FindDayException(ex.getMessage());
        }
    }
}
