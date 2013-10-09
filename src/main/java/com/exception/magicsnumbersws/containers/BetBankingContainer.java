package com.exception.magicsnumbersws.containers;

import com.exception.magicsnumbersws.entities.BetBanking;
import com.exception.magicsnumbersws.entities.BetBankingBetLimit;
import com.exception.magicsnumbersws.entities.BlockingNumberBetBanking;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 * @since 08-Oct-2013
 */
@XmlRootElement(name = "BetBankingContainer")
public class BetBankingContainer {

    private BetBanking betBanking;
    private List<BetBankingBetLimit> betBankingBetLimits;
    private List<BlockingNumberBetBanking> blockingNumbers;

    public BetBanking getBetBanking() {
        return betBanking;
    }

    public void setBetBanking(BetBanking betBanking) {
        this.betBanking = betBanking;
    }

    @XmlElement
    public List<BetBankingBetLimit> getBetBankingBetLimits() {
        return betBankingBetLimits;
    }

    public void setBetBankingBetLimits(List<BetBankingBetLimit> betBankingBetLimits) {
        this.betBankingBetLimits = betBankingBetLimits;
    }
    @XmlElement
    public List<BlockingNumberBetBanking> getBlockingNumbers() {
        return blockingNumbers;
    }

    public void setBlockingNumbers(List<BlockingNumberBetBanking> blockingNumbers) {
        this.blockingNumbers = blockingNumbers;
    }
}
