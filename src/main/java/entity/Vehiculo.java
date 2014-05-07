package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public class Vehiculo {
    @Id
    @GeneratedValue(generator = "Vehiculo")
    private Long id;
    private String placa;
    private String modelo;
    private String uso;
    private String marca;
    private String linea;
    private String capacidad;
    private Long idcontribuyente;
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    
    public String getplaca(){
        return placa;
    }
    public void setplaca(String placa){
        this.placa = placa;
    }
    
    public String getmodelo(){
        return modelo;
    }
    public void setmodelo(String modelo){
        this.modelo = modelo;
    }
    
    public String getuso(){
        return uso;
    }
    public void setuso(String uso){
        this.uso = uso;
    }
    
    public String getmarca(){
        return marca;
    }
    public void setmarca(String marca){
        this.marca = marca;
    }
    
    public String getlinea(){
        return linea;
    }
    public void setlinea(String linea){
        this.linea = linea;
    }
    
    public String getcapacidad(){
        return capacidad;
    }
    public void setcapacidad(String capacidad){
        this.capacidad = capacidad;
    }
    
    public Long getidcontribuyente(){
        return idcontribuyente;
    }
    public void setidcontribuyente(Long idcontribuyente){
        this.idcontribuyente = idcontribuyente;
    }
}
