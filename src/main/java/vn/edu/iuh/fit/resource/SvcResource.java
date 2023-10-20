package vn.edu.iuh.fit.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.entity.Service;
import vn.edu.iuh.fit.entity.ServicePrice;
import vn.edu.iuh.fit.service.SvcService;

import java.util.List;
import java.util.Map;

@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SvcResource {
    private SvcService svcService;

    public SvcResource() {
        svcService=new SvcService();
    }
    @POST
    public Response addService(Service service, ServicePrice servicePrice){
        if(svcService.addService(service, servicePrice)==true){
            return Response.status(Response.Status.OK).entity("Successful").build();
        }else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Failed").build();
        }
    }
    @PUT
    @Path("/{id}")
    public Response updateService(@PathParam("id")long svcID, Service service){
        if(svcService.updateService(service)==true){
            return Response.status(Response.Status.OK).entity("Successful").build();
        }else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Failed").build();
        }
    }
    @DELETE
    @Path("/{id}")
    public Response deleteService(@PathParam("id") long svcId){
        if(svcService.deleteService(svcId)==true){
            return Response.status(Response.Status.OK).entity("Successful").build();
        }else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Failed").build();
        }
    }
    @PUT
    @Path("/{id}/active")
    public Response activeService(@PathParam("id") long svcId){
        if(svcService.activeService(svcId)==true){
            return Response.status(Response.Status.OK).entity("Successful").build();
        }else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Failed").build();
        }
    }
    @GET
    @Path("/{id}")
    public Response getServiceByID(@PathParam("id") long svcId){
        Service service=svcService.getServiceByID(svcId);
        if(service!=null){
            return Response.ok(service).build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    public Response getAllService(){
        List<Service> rs=svcService.getAllService();
        if(rs!=null){
            return Response.ok(rs).build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


}
