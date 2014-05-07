package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public class Contribuyente {
    @Id
    @GeneratedValue(generator = "Contribuyente")
    private Long id;
    private String identificacion;
    private String nombre;
    private String direccion;
    private String ciudad;
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    
    public String getidentificacion(){
        return identificacion;
    }
    public void setidentificacion(String identificacion){
        this.identificacion = identificacion;
    }
    
    public String getnombre(){
        return nombre;
    }
    public void setnombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getdireccion(){
        return direccion;
    }
    public void setdireccion(String direccion){
        this.direccion = direccion;
    }
    
    public String getciudad(){
        return ciudad;
    }
    public void setciudad(String ciudad){
        this.ciudad = ciudad;
    }
}
