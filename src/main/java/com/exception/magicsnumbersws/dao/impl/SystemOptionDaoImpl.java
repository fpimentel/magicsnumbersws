package com.exception.magicsnumbersws.dao.impl;
import com.exception.magicsnumbersws.dao.SystemOptionDao;
import com.exception.magicsnumbersws.entities.SystemOption;
import com.exception.magicsnumbersws.exception.SaveSystemOptionsDataException;
import com.exception.magicsnumbersws.exception.SearchAllSystemOptionException;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cpimentel
 */
@Repository
public class SystemOptionDaoImpl implements SystemOptionDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SystemOptionDaoImpl() {
    }

    public SystemOptionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(SystemOption systemOption) {
        sessionFactory.getCurrentSession().save(systemOption);
    }

    @Override
    public void update(SystemOption systemOption) {
        sessionFactory.getCurrentSession().update(systemOption);
    }

    @Override
    public void delete(int systemOptionId) {
        sessionFactory.getCurrentSession().delete(findById(systemOptionId));
    }

    @Override
    public SystemOption findById(int id) {
        return (SystemOption) sessionFactory.getCurrentSession().get(SystemOption.class, id);
    }

    /**
     *
     * @return @throws SearchAllSystemOptionException
     */
    @Override
    public List<SystemOption> findAll() throws SearchAllSystemOptionException {
        return (List<SystemOption>) sessionFactory.getCurrentSession()
                .createCriteria(SystemOption.class)
                .setFetchMode("status", FetchMode.JOIN)
                .setFetchMode("category", FetchMode.JOIN)
                .list();
    }

    @Override
    public void saveSystemOptionsData(List<SystemOption> systemOptions) throws SaveSystemOptionsDataException {
        for (SystemOption currSysteOption : systemOptions) {
            SystemOption systemOption = (SystemOption) sessionFactory.getCurrentSession()
                    .get(currSysteOption.getClass(), currSysteOption.getId());
            if (systemOption != null) {
                BeanUtils.copyProperties(currSysteOption, systemOption);
                update(systemOption);
            } else {
                add(currSysteOption);
            }
        }
    }
}
