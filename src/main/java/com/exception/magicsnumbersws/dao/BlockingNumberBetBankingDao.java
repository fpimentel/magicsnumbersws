package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;

/**
 *
 * @author fpimentel
 * @since 03-sept-2013
 */
public interface BlockingNumberBetBankingDao {

    public void add(BlockingNumberBetBanking blockingNumber);

    public void update(BlockingNumberBetBanking blockinNumber);

    public void delete(int blockingNumberId);
        
    public BlockingNumberBetBanking findById(int id);
}
