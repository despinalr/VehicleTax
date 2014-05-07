package rest;

import entity.Vehiculo;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;
import logic.ILogic;

@Path("/Service")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Service {
    
    @Inject
    protected ILogic _logic;
    
    @GET
    @Path("{placa}")
    public Vehiculo getVehiculo(@PathParam("placa") String placa){
        return _logic.getVehiculo(placa);
    }
    
    @PUT
    public void updateVehiculo(){
            return;
    }
}
