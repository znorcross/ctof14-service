package com.intuit.ctof14.resources;

import com.intuit.ctof14.MockData;
import com.intuit.ctof14.model.Bill;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: znorcross
 * Date: 5/14/14
 * Time: 1:29 PM
 */
@Path("/v1/bills")
@Api(value="/v1/bills", description="Add a bill for the roommates to pay")
public class BillsResource {
    private static Logger logger = Logger.getLogger(BillsResource.class);

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation(value = "Add a Bill", notes = "More notes about this method")
    public Response addBill(@ApiParam(
            name = "Bill",
            value = "Bill",
            required = true,
            defaultValue = "{\"amount\":100.00, \"description\": \"blah\"}")
                         Bill pBill) {
        try {
            Map<String, BigDecimal> billDetails = new HashMap<String, BigDecimal>();
            BigDecimal roommateAmount = pBill.getAmount().subtract(MockData.PENALTY_AMOUNT).divide(new BigDecimal(MockData.roommates.length)).setScale(2, RoundingMode.HALF_UP);
            for (String roommate : MockData.roommates) {
                billDetails.put(roommate, roommateAmount);
            }

            // todo add penalty (rounding + 1)

            MockData.getBillMap().put(pBill.getDescription(), billDetails);

            // todo post to activity feed

            return Response.ok().build();
        } catch (Exception e) {
            logger.error(e);
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
