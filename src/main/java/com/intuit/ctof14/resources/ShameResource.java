package com.intuit.ctof14.resources;

import com.intuit.ctof14.MockData;
import com.intuit.ctof14.model.Bill;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: znorcross
 * Date: 5/14/14
 * Time: 1:29 PM
 */
@Path("/v1/shame/bills")
@Api(value="/v1/shame/bills", description="Add a bill for the roommates to pay")
public class ShameResource {
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation(value = "Blab a message", notes = "More notes about this method")
    public Response blab(@ApiParam(
            name = "Bill",
            value = "Bill",
            required = true,
            defaultValue = "{\"amount\":100.00, \"description\": \"blah\"}")
                         Bill pBill) {
        try {
            BigDecimal roommateAmount = pBill.getAmount();
            for (String roommate : MockData.roommates) {

            }
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }
}
