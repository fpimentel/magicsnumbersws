package com.exception.magicsnumbersws.dao.impl;
import com.exception.magicsnumbersws.dao.TimeDao;
import com.exception.magicsnumbersws.entities.Time;
import com.exception.magicsnumbersws.exception.FindTimeException;
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
public class TimeDaoImpl implements TimeDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger LOG = Logger.getLogger(TimeDaoImpl.class.getName());

    public TimeDaoImpl() {
    }

    public TimeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Time> findAll() throws FindTimeException {
        try {
            List<Time> times = sessionFactory.getCurrentSession()
                    .createCriteria(Time.class)
                    .list();
            return times;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new FindTimeException(ex.getMessage());
        }
    }   
}
