package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.WinningNumberDao;
import com.exception.magicsnumbersws.entities.WinningNumber;
import com.exception.magicsnumbersws.exception.SaveWinningNumberDataException;
import com.exception.magicsnumbersws.exception.SearchWinningNumbersException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cpimentel
 * @since 19-Dic-2013
 */
@Repository
public class WinningNumberDaoImpl implements WinningNumberDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(WinningNumberDaoImpl.class.getName());

    public WinningNumberDaoImpl() {
    }

    public WinningNumberDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(WinningNumber winningNumber) throws SaveWinningNumberDataException{
        try{
            sessionFactory.getCurrentSession().save(winningNumber);
        }
        catch(Exception ex){
            throw new SaveWinningNumberDataException(ex.getMessage(),ex);
        }
    }

    @Override
    public void update(WinningNumber winningNumber) throws SaveWinningNumberDataException{
        try{
            sessionFactory.getCurrentSession().update(winningNumber);
        }
        catch(Exception ex){
            throw new SaveWinningNumberDataException(ex.getMessage(),ex);
        }
    }

    @Override
    public void delete(int winningNumberId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WinningNumber> findWinningNumber(String fromDate, String toDate) throws SearchWinningNumbersException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date fDate = formatter.parse(fromDate);
            Date tDate = formatter.parse(toDate);
            List<WinningNumber> winningNumbers;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tDate);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.SECOND, -1);
            String queryString = "from WinningNumber wn where wn.drawingDate between :fromDate and :toDate ";
            Query query = sessionFactory.getCurrentSession().createQuery(queryString);
            query.setParameter("fromDate", fDate);
            query.setParameter("toDate", calendar.getTime());
            winningNumbers=query.list();
            return winningNumbers;
        } catch (Exception ex) {            
            Logger.getLogger(WinningNumberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new SearchWinningNumbersException(ex.getMessage());
        }
    }
    @Override
    public WinningNumber findWinningNumber(int lotteryId, int timeId,String drawingDate) throws SearchWinningNumbersException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dDate = formatter.parse(drawingDate);
            //Date tDate = formatter.parse(drawingDate);
            WinningNumber winningNumber;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dDate);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.SECOND, -1);
            String queryString = "from WinningNumber wn where wn.drawingDate between :fromDate and :toDate and wn.lottery.id = :lotteryId and wn.time.id = :timeId";
            Query query = sessionFactory.getCurrentSession().createQuery(queryString);
            query.setParameter("fromDate", dDate);
            query.setParameter("toDate", calendar.getTime());
            query.setParameter("lotteryId", lotteryId);
            query.setParameter("timeId", timeId);
            winningNumber= (WinningNumber)query.uniqueResult();
            return winningNumber;
        } catch (Exception ex) {            
            Logger.getLogger(WinningNumberDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new SearchWinningNumbersException(ex.getMessage());
        }
    }
}
