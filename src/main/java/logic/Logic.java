package logic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import entity.Vehiculo;
import entity.Contribuyente;

@Default
@Stateless
@LocalBean
public class Logic implements ILogic {
    
    @PersistenceContext(unitName="VehiculoPU")
    protected EntityManager entityManager;
    
    public Vehiculo getVehiculo(String placa) {
        Query q = entityManager.createQuery("select u from Vehiculo u where u.placa = '" + placa + "'");
        List<Vehiculo> vehiculos = q.getResultList();
        return vehiculos.get(0);
    }
    
    public Vehiculo updateVehiculo(Vehiculo vehiculo) {
        return entityManager.merge(vehiculo);
    }
    
    public Contribuyente getContribuyente(Long id) {
        return entityManager.find(Contribuyente.class, id);
    }
    
    public Contribuyente updateContribuyente(Contribuyente contribuyente) {
        return entityManager.merge(contribuyente);
    }
}
