package com.exception.magicsnumbersws.containers;

import com.exception.magicsnumbersws.entities.Lottery;
import com.exception.magicsnumbersws.entities.LotteryCloseHour;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 * @since 25-sept-2013
 */
@XmlRootElement(name = "lotteryContainer")
public class LotteryContainer {

    private Lottery lottery;
    private List<LotteryCloseHour> lotteryCloseHour;    

    @XmlElement
    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    @XmlElement
    public List<LotteryCloseHour> getLotteryCloseHour() {
        return lotteryCloseHour;
    }

    public void setLotteryCloseHour(List<LotteryCloseHour> lotteryCloseHour) {
        this.lotteryCloseHour = lotteryCloseHour;
    }            
}
