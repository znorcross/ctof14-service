package com.intuit.ctof14.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: znorcross
 * Date: 5/14/14
 * Time: 1:01 PM
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "bill",
        "owesList"
})
@XmlRootElement(name = "Owes")
public class Owes {
    private String bill;
    private List<Owe> owesList;

    @XmlElement(name = "bill")
    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    @XmlElement(name = "owesList")
    public List<Owe> getOwesList() {
        return owesList;
    }

    public void setOwesList(List<Owe> owesList) {
        this.owesList = owesList;
    }
}