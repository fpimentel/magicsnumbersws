package com.exception.magicsnumbersws.service;

import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.exception.SaveConsortiumDataException;
import com.exception.magicsnumbersws.exception.SearchAllConsortiumException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 * @since 02-sept-2013
 */
@Service
public interface ConsortiumService {

    public void add(Consortium consortium);

    public void update(Consortium consortium);

    public void delete(int consortiumId);

    @Transactional(readOnly = true)
    public Consortium findById(int id);

    @Transactional(readOnly = true)
    public List<Consortium> findActiveConsortium() throws SearchAllConsortiumException;

    @Transactional(readOnly = true)
    public List<Consortium> findByUserId(int userId) throws SearchAllConsortiumException;

    public void saveConsortiumsData(List<Consortium> consortiums) throws SaveConsortiumDataException;

    public void saveConsortiumData(Consortium consortium) throws SaveConsortiumDataException;
}
