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
        "billDescription",
        "amount",
        "payerName"
})
@XmlRootElement(name = "Payment")
public class Payment {
    private String billDescription;
    private BigDecimal amount;
    private String payerName;

    @XmlElement(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @XmlElement(name = "billDescription")
    public String getBillDescription() {
        return billDescription;
    }

    public void setBillDescription(String billDescription) {
        this.billDescription = billDescription;
    }

    @XmlElement(name = "payerName")
    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }
}
