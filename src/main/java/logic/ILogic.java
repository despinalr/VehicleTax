package logic;

import entity.Vehiculo;
import entity.Contribuyente;
import entity.Pago;
import java.util.List;

public interface ILogic {
    public Vehiculo getVehiculo(String placa);
    public Vehiculo updateVehiculo(Vehiculo vehiculo);
    
    public Contribuyente getContribuyente(Long id);
    public Contribuyente updateContribuyente(Contribuyente contribuyente);
    
    public Pago createPago(Pago pago);
    
    public List consultarPagosPendientes();
    public List consultarPagosRealizados();
}
