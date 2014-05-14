package com.intuit.ctof14.resources;

import com.intuit.ctof14.MockData;
import com.intuit.ctof14.model.Payment;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: znorcross
 * Date: 5/14/14
 * Time: 1:46 PM
 */
@Path("/v1/payments")
@Api(value="/v1/payments", description="Pay a part of the bill")
public class PaymentsResource {
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @ApiOperation(value = "Add a payment", notes = "More notes about this method")
    public Response addPayment(@ApiParam(
            name = "Payment",
            value = "Payment",
            required = true,
            defaultValue = "{\"billDescription\":\"blah\", \"amount\":100.00, \"payerName\":\"Tom\"}")
                                Payment pPayment) {
        try {
            Map<String, BigDecimal> billDetails = MockData.getBillMap().get(pPayment.getBillDescription());
            if(billDetails == null || billDetails.get(pPayment.getPayerName()) == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Bill not found").build();
            }

            if(billDetails.get(pPayment.getPayerName()).subtract(pPayment.getAmount()).compareTo(BigDecimal.ZERO) <= 0) {
                billDetails.remove(pPayment.getPayerName());
            } else {
                billDetails.put(pPayment.getPayerName(), billDetails.get(pPayment.getPayerName()).subtract(pPayment.getAmount()));
            }

            // todo call stripe api

            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }
}
