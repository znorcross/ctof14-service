package com.intuit.ctof14;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    private static BigDecimal PENALTY_AMOUNT = new BigDecimal(1);

    // Bill description -> Roommate -> amount owed
    private static List<Map<String, Map<String, BigDecimal>>> billsList = new ArrayList<Map<String, Map<String, BigDecimal>>>();

    public static List<Map<String, Map<String, BigDecimal>>> getBillsList() {
        return billsList;
    }
}
