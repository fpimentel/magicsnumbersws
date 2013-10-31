package com.exception.magicsnumbersws.dao;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;
import com.exception.magicsnumbersws.exception.FindBlockingNumberException;

/**
 *
 * @author fpimentel
 * @since 03-sept-2013
 */
public interface BlockingNumberBetBankingDao {
    public void add(BlockingNumberBetBanking blockingNumber);
    public void update(BlockingNumberBetBanking blockinNumber);
    //@Transactional
    public void delete(int blockingNumberId);        
    public BlockingNumberBetBanking findById(int id);    
    public void deleteByBetBanking(int betBankingId);
    public boolean isNumberBlock(int betBankingId,int number) throws FindBlockingNumberException;
}
