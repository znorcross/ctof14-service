

package com.intuit.ctof14.model;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: znorcross
 * Date: 5/14/14
 * Time: 1:01 PM
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "amount",
        "roomMate"
})
@XmlRootElement(name = "Owe")
public class Owe {
    private BigDecimal amount;
    private String roomMate;

    @XmlElement(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @XmlElement(name = "roomMate")
    public String getRoomMate() {
        return roomMate;
    }

    public void setRoomMate(String roomMate) {
        this.roomMate = roomMate;
    }
}
