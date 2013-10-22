package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.LotteryCloseHourDao;
import com.exception.magicsnumbersws.entities.LotteryCloseHour;
import com.exception.magicsnumbersws.exception.FindLotteryCloseHourException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 */
@Repository
public class LotteryCloseHourDaoImpl implements LotteryCloseHourDao {

    private static int ACTIVO = 1;
    @Autowired
    private SessionFactory sessionFactory;

    public LotteryCloseHourDaoImpl() {
    }

    public LotteryCloseHourDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(LotteryCloseHour lotteryCloseHour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(LotteryCloseHour lotteryCloseHour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int lotteryCloseHourId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LotteryCloseHour findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LotteryCloseHour> findAll() throws FindLotteryCloseHourException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LotteryCloseHour> findAvailableTimesByLotteryId(int lotteryId) throws FindLotteryCloseHourException {
        final Calendar cal = Calendar.getInstance();        
        final int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        
        List<LotteryCloseHour> lotteryCloseHours = sessionFactory.getCurrentSession()
                .createCriteria(LotteryCloseHour.class)
                .setFetchMode("lottery", FetchMode.JOIN)
                .setFetchMode("day", FetchMode.JOIN)
                .add(Restrictions.eq("lottery.id", lotteryId))
                .add(Restrictions.eq("day.id", dayOfWeek))
                .list();
        
        return lotteryCloseHours;
    }
}
