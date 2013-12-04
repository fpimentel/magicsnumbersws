package com.exception.magicsnumbersws.service;

import com.exception.magicsnumbersws.entities.ConsortiumGeneralLimit;
import com.exception.magicsnumbersws.exception.DeleteConsortiumGeneralLimitException;
import com.exception.magicsnumbersws.exception.FindConsortiumGeneralLimitException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fpimentel
 * @since 03-dic-2013
 */
@Service
public interface ConsortiumGeneralLimitService {
    
    public void add(ConsortiumGeneralLimit consLimit);

    public void update(ConsortiumGeneralLimit consLimit);

    public void delete(int consLimitId);

    public void deleteByConsortiumId(int consortiumId) throws DeleteConsortiumGeneralLimitException;

    public ConsortiumGeneralLimit findById(int id) throws FindConsortiumGeneralLimitException;

    public List<ConsortiumGeneralLimit> findByConsortiumId(int consortiumId) throws FindConsortiumGeneralLimitException;
}
