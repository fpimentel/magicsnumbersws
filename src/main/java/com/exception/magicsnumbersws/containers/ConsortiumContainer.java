package com.exception.magicsnumbersws.containers;

import com.exception.magicsnumbersws.entities.Consortium;
import com.exception.magicsnumbersws.entities.ConsortiumGeneralLimit;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpimentel
 * @since 04-dic-2013
 */
@XmlRootElement(name = "consortiumContainer")
public class ConsortiumContainer {

    private Consortium consortium;
    private List<ConsortiumGeneralLimit> consortiumGeneralLimit;    

    public Consortium getConsortium() {
        return consortium;
    }

    public void setConsortium(Consortium consortium) {
        this.consortium = consortium;
    }

    public List<ConsortiumGeneralLimit> getConsortiumGeneralLimit() {
        return consortiumGeneralLimit;
    }

    public void setConsortiumGeneralLimit(List<ConsortiumGeneralLimit> consortiumGeneralLimit) {
        this.consortiumGeneralLimit = consortiumGeneralLimit;
    }
 
}
