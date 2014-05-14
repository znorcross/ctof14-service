package com.intuit.ctof14.model;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: znorcross
 * Date: 5/14/14
 * Time: 1:07 PM
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "amount",
        "payerId"
})
@XmlRootElement(name = "Payment")
public class Payment {
    private BigDecimal amount;
    private String payerId;

    @XmlElement(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @XmlElement(name = "payerId")
    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }
}
