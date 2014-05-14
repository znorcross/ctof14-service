package com.intuit.ctof14;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: znorcross
 * Date: 5/14/14
 * Time: 1:15 PM
 */
public class MockData {
    public static String[] roommates = new String[]{"Shankar", "Susan", "Jake"};
    public static String PENALTY_NAME = "Penalty";
    public static BigDecimal PENALTY_AMOUNT = new BigDecimal(1);

    // Bill description -> Roommate -> amount owed
    private static Map<String, Map<String, BigDecimal>> billMap = new HashMap<String, Map<String, BigDecimal>>();

    public static Map<String, Map<String, BigDecimal>> getBillMap() {
        return billMap;
    }
}
