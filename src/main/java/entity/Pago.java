package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public class Pago {
    @Id
    @GeneratedValue(generator = "Pago")
    private Long id;
    private Long idvehiculo;
    private String fecha;
    private Long valor;
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getidvehiculo(){
        return idvehiculo;
    }
    public void setidvehiculo(Long idvehiculo){
        this.idvehiculo = idvehiculo;
    }
    
    public Long getvalor(){
        return valor;
    }
    public void setvalor(Long valor){
        this.valor = valor;
    }
    
    public String getfecha(){
        return fecha;
    }
    public void setfecha(String fecha){
        this.fecha = fecha;
    }
}
