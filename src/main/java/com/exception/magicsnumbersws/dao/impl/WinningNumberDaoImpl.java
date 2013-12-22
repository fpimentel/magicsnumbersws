package com.exception.magicsnumbersws.dao.impl;

import com.exception.magicsnumbersws.dao.WinningNumberDao;
import com.exception.magicsnumbersws.entities.WinningNumber;
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
    public void add(WinningNumber winningNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(WinningNumber winningNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
