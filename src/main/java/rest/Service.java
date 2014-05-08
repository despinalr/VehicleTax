package rest;

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

import entity.Vehiculo;
import entity.Contribuyente;
import entity.Pago;
import java.util.List;

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
    
    @POST
    public Vehiculo updateVehiculo(Vehiculo vehiculo){
            return _logic.updateVehiculo(vehiculo);
    }
    
    @GET
    @Path("/Contribuyente/{id}")
    public Contribuyente getContribuyente(@PathParam("id") Long idContribuyente){
        return _logic.getContribuyente(idContribuyente);
    }
    
    @PUT
    public Contribuyente updateContribuyente(Contribuyente contribuyente){
            return _logic.updateContribuyente(contribuyente);
    }
    
    @POST
    @Path("/Pago")
    public Pago createPago(Pago pago){
            return _logic.createPago(pago);
    }
    
    @GET
    @Path("/Pago/Pendientes")
    public List consultarPagosPendientes(){
        return _logic.consultarPagosPendientes();
    }
    
    @GET
    @Path("/Pago/Realizados")
    public List consultarPagosRealizados(){
        return _logic.consultarPagosRealizados();
    }
}
