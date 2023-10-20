package vn.edu.iuh.fit.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.service.InvoiceService;

@Path("/invoice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InvoiceResource {
    private InvoiceService invoiceService;

    public InvoiceResource() {
        invoiceService=new InvoiceService();
    }
    @GET
    @Path("/calcTotalPrice/{id}")
    public Response calcTotalPrice(@PathParam("id") long apptNo){
        Double rs= invoiceService.calcTotalPrice(apptNo);
        if(rs!=0){
            return Response.ok(rs).build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
