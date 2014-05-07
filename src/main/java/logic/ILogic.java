package logic;

import entity.Vehiculo;

public interface ILogic {
    public Vehiculo getVehiculo(String placa);
    public Vehiculo updateVehiculo(Vehiculo vehiculo);
}
