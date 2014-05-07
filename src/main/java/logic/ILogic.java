package logic;

import entity.Vehiculo;
import entity.Contribuyente;

public interface ILogic {
    public Vehiculo getVehiculo(String placa);
    public Vehiculo updateVehiculo(Vehiculo vehiculo);
    
    public Contribuyente getContribuyente(Long id);
    public Contribuyente updateContribuyente(Contribuyente contribuyente);
}
