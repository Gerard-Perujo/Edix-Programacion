package modelo.javabeans;

import java.util.Objects;

public class Departamento {
	
	
	// creamos la clase departamento en ella tenemos que crear el atributo localidad para que quede
	//referenciado con la clase localidad
	private int idDepar;
	private String descripcion;
	private Localidad localidad;
	
	
	public Departamento() {
		super();
	}
	
	public Departamento (int idDepar, String descripcion, Localidad localidad) {
		super();
		this.idDepar = idDepar;
		this.descripcion = descripcion;
		this.localidad = localidad;
	}
	
	
	public int getIdDepar() {
		return idDepar;
	}
	
	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Localidad getLocalidad() {
		return  localidad;
	}
	
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	
	@Override
	public String toString() {
		return "Departamento [idDepar=" + idDepar + "descripcion=" + descripcion
				+ "localidad=" + localidad + "]";
				
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idDepar);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return idDepar == other.idDepar;
		
		
		
	}
	

}
