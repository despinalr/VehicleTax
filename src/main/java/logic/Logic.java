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
import entity.Pago;

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
    
    public Pago createPago(Pago pago) {
        entityManager.persist(pago);
        return pago;
    }
    
    public List consultarPagosPendientes() {
        return consultarPagos("");
    }
    
    public List consultarPagosRealizados() {
        return consultarPagos(" not");
    }
    
    private List consultarPagos(String value) {
        String query = "select contribuyente.nombre, contribuyente.identificacion, contribuyente.DIRECCION, contribuyente.CIUDAD, vehiculo.placa, pago.fecha, pago.valor\n" +
                        "from vehiculo inner join contribuyente on vehiculo.idcontribuyente = contribuyente.id left join pago on vehiculo.id = pago.idvehiculo\n" +
                        "where pago.idvehiculo is" + value +" null";
        Query q = entityManager.createNativeQuery(query);
        return q.getResultList();
    }
}
