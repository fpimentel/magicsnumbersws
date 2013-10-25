package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.LotteryCloseHourDao;
import com.exception.magicsnumbersws.entities.LotteryCloseHour;
import com.exception.magicsnumbersws.entities.Time;
import com.exception.magicsnumbersws.exception.CloseHourLotteryConfigNotFoundtException;
import com.exception.magicsnumbersws.exception.FindLotteryCloseHourException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.maven.doxia.util.StringUtil;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fpimentel
 */
@Repository
public class LotteryCloseHourDaoImpl implements LotteryCloseHourDao {
    
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
    public List<Time> findAvailableTimesByLotteryId(int lotteryId) throws FindLotteryCloseHourException,CloseHourLotteryConfigNotFoundtException {
        
        final Calendar cal = Calendar.getInstance();        
        final int hour = cal.get(Calendar.HOUR_OF_DAY);        
        String  minute = String.format("%02d", cal.get(Calendar.MINUTE));
        final String currHourAndMinute = hour + "" + minute;
        final int currentHourAndMinuteInt = Integer.parseInt(currHourAndMinute);
        final int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        
        List<LotteryCloseHour> lotteryCloseHours = sessionFactory.getCurrentSession()
                .createCriteria(LotteryCloseHour.class)
                .setFetchMode("lottery", FetchMode.JOIN)
                .setFetchMode("day", FetchMode.JOIN)
                .createAlias("day", "d")
                .add(Restrictions.eq("lottery.id", lotteryId))
                .add(Restrictions.eq("d.dayOfWeek", dayOfWeek))
                .list();
        if(lotteryCloseHours.isEmpty()){
              throw new CloseHourLotteryConfigNotFoundtException("No existen configuraciones de hora de cierre para esa loteria(" + lotteryId + ")" + " y dia");
        }
        List<Time> availableTimes = new ArrayList<Time>();
        
        for(LotteryCloseHour currCloseHour : lotteryCloseHours){
           String hourMinute[]= currCloseHour.getHour().split(":");
           final String hourAndMinute = hourMinute[0] + "" + hourMinute[1];
           final int hourAndMinuteInt = Integer.parseInt(hourAndMinute);
           if(hourAndMinuteInt > currentHourAndMinuteInt){
               availableTimes.add(currCloseHour.getTime());
           }
        }
        return availableTimes;
    }
}
