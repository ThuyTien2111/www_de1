package vn.edu.iuh.fit.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.convert.ServicePriceDTO;
import vn.edu.iuh.fit.dao.ServicePriceDao;
import vn.edu.iuh.fit.entity.Service;
import vn.edu.iuh.fit.service.SvcPriceService;

import java.util.List;

@Path("/service-price")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SvcPriceResource {
    private SvcPriceService svcPriceService;

    public SvcPriceResource() {
        svcPriceService=new SvcPriceService();
    }
    @GET
    @Path("/getCheapestPrice")
    public Response getCheapestPrice(){
        List<ServicePriceDTO> rs=svcPriceService.getCheapestPrice();
        if(rs!=null){
            return Response.ok(rs).build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
